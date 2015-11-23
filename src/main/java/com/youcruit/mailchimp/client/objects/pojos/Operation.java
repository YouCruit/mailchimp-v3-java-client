package com.youcruit.mailchimp.client.objects.pojos;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import com.youcruit.mailchimp.client.http.HttpClient.Method;
import com.youcruit.mailchimp.client.objects.pojos.request.AbstractRequest;
import com.youcruit.mailchimp.client.serializers.ArrayStringAdapter;
import com.youcruit.mailchimp.client.serializers.BodyAdapter;
import com.youcruit.mailchimp.client.serializers.QueryParametersAdapter;

public class Operation<T> {

    public Method method;
    @JsonAdapter(ArrayStringAdapter.class)
    public String[] path;
    public Map<String, String> params;
    @JsonAdapter(BodyAdapter.class)
    public AbstractRequest body;
    @SerializedName("operation_id")
    public String operationId;
    public Class<T> responseClass;

    public enum Path {
	LISTS("lists"), MEMBERS("members"), BATCHES("batches");

	private String pathField;

	Path(String pathField) {
	    this.pathField = pathField;
	}

	String getPathField() {
	    return this.pathField;
	}
    }

    private Operation(Method method, Map<String, String> params, AbstractRequest body, String operationId, Class<T> responseClass, String... path) {
	this.method = method;
	this.path = path;
	this.body = body;
	this.operationId = operationId;
	this.responseClass = responseClass;

	if (params == null) {
	    this.params = Collections.emptyMap();
	} else {
	    this.params = params;
	}
    }

    public static class OperationBuilder {
	private Method method;
	private List<String> paths;
	private Map<String, String> params;
	private AbstractRequest body;
	private String operationId;

	public OperationBuilder() {
	    this.paths = new ArrayList<>();
	}

	public OperationBuilder method(final Method method) {
	    this.method = method;
	    return this;
	}

	public OperationBuilder path(final String path) {
	    this.paths.add(path);
	    return this;
	}

	public OperationBuilder path(final Path path) {
	    this.paths.add(path.getPathField());
	    return this;
	}

	public OperationBuilder params(final QueryParameters params) {
	    this.params = new QueryParametersAdapter().toQueryParameters(params);
	    return this;
	}

	public OperationBuilder body(final AbstractRequest body) {
	    this.body = body;
	    return this;
	}

	public OperationBuilder operationId(final String operationId) {
	    this.operationId = operationId;
	    return this;
	}

	public<T> Operation<T> createOperation(Class<T> responseClass) {
	    return new Operation<T>(method, params, body, operationId, responseClass, paths.toArray(new String[paths.size()]));
	}
    }
}
