package com.youcruit.mailchimp.client.http;

import java.io.IOException;
import java.net.URI;
import java.util.Collections;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.youcruit.mailchimp.client.exceptions.MailchimpException;
import com.youcruit.mailchimp.client.objects.pojos.Operation;
import com.youcruit.mailchimp.client.objects.pojos.request.AbstractRequest;

import okhttp3.HttpUrl;
import okhttp3.Interceptor;
import okhttp3.MediaType;
import okhttp3.Request;
import okhttp3.Request.Builder;
import okhttp3.RequestBody;
import okhttp3.Response;

public class OkHttpClient implements HttpClient {
    
    private static final MediaType APPLICATION_JSON = MediaType.parse("application/json");

    private static final Logger LOGGER = LogManager.getLogger(OkHttpClient.class);

    private final okhttp3.OkHttpClient client;

    private final Gson gson;

    private final URI baseUri;

    public OkHttpClient(String password, URI baseUri) {
	okhttp3.OkHttpClient.Builder okHttpClient = new okhttp3.OkHttpClient.Builder();
	okHttpClient.readTimeout(60, TimeUnit.SECONDS);
	okHttpClient.connectTimeout(30, TimeUnit.SECONDS);
	okHttpClient.writeTimeout(30, TimeUnit.SECONDS);
	if (password != null) {
	    okHttpClient.authenticator(new BasicAuthenticator("mailchimp-v3-java-client", password));
	}
	okHttpClient.interceptors().add(new UserAgentInterceptor());
	this.baseUri = baseUri;
	this.client = okHttpClient.build();
	this.gson = createGson();
    }

    public OkHttpClient(URI baseUri) {
	this(null, baseUri);
    }

    protected Gson createGson() {
	return new GsonBuilder().create();
    }

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
	    LOGGER.warn("Error response json from mandrill " + uri + " : " + responseJson);
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
