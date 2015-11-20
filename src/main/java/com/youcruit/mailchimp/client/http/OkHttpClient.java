package com.youcruit.mailchimp.client.http;

import java.io.IOException;
import java.net.URI;
import java.util.Collections;
import java.util.Map;

import org.apache.log4j.Logger;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.squareup.okhttp.HttpUrl;
import com.squareup.okhttp.Interceptor;
import com.squareup.okhttp.MediaType;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.Request.Builder;
import com.squareup.okhttp.RequestBody;
import com.squareup.okhttp.Response;
import com.youcruit.mailchimp.client.exceptions.MailchimpException;
import com.youcruit.mailchimp.client.objects.pojos.Operation;
import com.youcruit.mailchimp.client.objects.pojos.request.AbstractRequest;

public class OkHttpClient implements HttpClient {
    
    private static final MediaType APPLICATION_JSON = MediaType.parse("application/json");

    private static final Logger LOGGER = Logger.getLogger(OkHttpClient.class);

    private final com.squareup.okhttp.OkHttpClient client;

    private final Gson gson;

    private final URI baseUri;

    public OkHttpClient(String password, URI baseUri) {
	com.squareup.okhttp.OkHttpClient okHttpClient = new com.squareup.okhttp.OkHttpClient();
	if (password != null) {
	    okHttpClient.setAuthenticator(new BasicAuthenticator("mailchimp-v3-java-client", password));
	}
	okHttpClient.interceptors().add(new UserAgentInterceptor());
	this.baseUri = baseUri;
	client = okHttpClient;
	this.gson = createGson();
    }

    public OkHttpClient(URI baseUri) {
	this(null, baseUri);
    }

    protected Gson createGson() {
	return new GsonBuilder().create();
    }

    @SuppressWarnings("unchecked")
    @Override
    public <V> V sync(Operation<V> operation) throws IOException {
	return sync(operation.body, operation.method, operation.responseClass, operation.params, operation.path);
    }

    @Override
    public <V> V sync(AbstractRequest requestBody, Method method, Class<V> responseClass, Map<String, String> queryParameters, String... pathSegments) throws IOException {
	URI uri = pathToUri(queryParameters, pathSegments);
	final Request request = createRequest(uri, requestBody, method);
	final Response response = client.newCall(request).execute();
	String responseJson = response.body().string();
	if (LOGGER.isTraceEnabled()) {
	    LOGGER.trace("Response json for " + uri + " : " + responseJson);
	}
	if (response.isSuccessful()) {
	    if (Void.class.getName().equals(responseClass.getName())) {
		return null;
	    }
	    return gson.fromJson(responseJson, responseClass);
	} else {
	    throw new MailchimpException(response.code(), response.message(), uri);
	}
    }

    private Request createRequest(URI uri, Object requestBody, HttpClient.Method method) {
	Request.Builder requestBuilder = new Request.Builder().url(uri.toString());
	RequestBody payload = null;
	if (requestBody == null && method == Method.POST) {
	    requestBody = Collections.emptyMap();
	}
	if (requestBody != null) {
	    String requestString = gson.toJson(requestBody);
	    if (LOGGER.isDebugEnabled()) {
		StringBuilder sb = new StringBuilder(method.name()).append(" Request for ").append(uri);
		LOGGER.debug(sb);
		if (LOGGER.isTraceEnabled()) {
		    sb.append(" : ").append(requestBody);
		    LOGGER.trace(sb);
		}
	    }
	    payload = RequestBody.create(APPLICATION_JSON, requestString.getBytes(UTF8));
	}
	requestBuilder.method(method.name(), payload);
	return requestBuilder.build();
    }

    private static class UserAgentInterceptor implements Interceptor {

	@Override
	public Response intercept(Chain chain) throws IOException {
	    Request originalRequest = chain.request();
	    Builder builder = originalRequest.newBuilder();
	    builder.removeHeader("User-Agent").addHeader("User-Agent", USER_AGENT);
	    return chain.proceed(builder.build());
	}
    }

    private URI pathToUri(Map<String, String> queryParameters, String... pathSegments) {
	HttpUrl.Builder builder = HttpUrl.get(baseUri).newBuilder();
	for (String pathSegment : pathSegments) {
	    builder.addPathSegment(pathSegment);
	}
	for (Map.Entry<String, String> e : queryParameters.entrySet()) {
	    builder.addQueryParameter(e.getKey(), e.getValue());
	}
	return builder.build().uri();
    }
}
