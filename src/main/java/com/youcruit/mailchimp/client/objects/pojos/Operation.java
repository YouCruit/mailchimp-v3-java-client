package com.youcruit.mailchimp.client.objects.pojos;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.google.gson.annotations.SerializedName;
import com.youcruit.mailchimp.client.http.HttpClient.Method;
import com.youcruit.mailchimp.client.objects.pojos.request.AbstractRequest;
import com.youcruit.mailchimp.client.serializers.RFC3339TypeAdapter;

public class Operation {

    public Method method;
    public String[] path;
    public Map<String, String> params;
    public AbstractRequest body;
    @SerializedName("operation_id")
    public String operationId;
    public Class<?> responseClass;

    public enum Path {
	LISTS("lists"), MEMBERS("members");

	private String pathField;

	Path(String pathField) {
	    this.pathField = pathField;
	}

	String getPathField() {
	    return this.pathField;
	}
    }

    private Operation() {
    }

    private Operation(Method method, Map<String, String> params, AbstractRequest body, String operationId, Class<?> responseClass, String... path) {
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
	private Class<?> responseClass;

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
	    this.params = toQueryParameters(params);
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

	public OperationBuilder responseClass(final Class<?> responseClass) {
	    this.responseClass = responseClass;
	    return this;
	}

	public Operation createOperation() {
	    return new Operation(method, params, body, operationId, responseClass, paths.toArray(new String[paths.size()]));
	}

	public Map<String, String> toQueryParameters(QueryParameters queryParameters) {
	    Map<String, String> result;
	    if (queryParameters != null) {
		result = new HashMap<>();
		for (Field field : queryParameters.getClass().getFields()) {
		    String key = field.getName();
		    Object value;
		    try {
			value = field.get(queryParameters);
		    } catch (IllegalAccessException e) {
			throw new RuntimeException(e.getMessage(), e);
		    }
		    if (value != null) {
			SerializedName annotation = field.getAnnotation(SerializedName.class);
			if (annotation != null) {
			    key = annotation.value();
			}
			String valueString = value.toString();
			if (value instanceof Collection<?>) {
			    valueString = listToString(value);
			} else if (value instanceof Date) {
			    RFC3339TypeAdapter rfc3339TypeAdapter = new RFC3339TypeAdapter();
			    valueString = rfc3339TypeAdapter.getDateFormat().format(value);
			}
			result.put(key, valueString);
		    }
		}
	    } else {
		result = Collections.emptyMap();
	    }
	    return result;
	}

	private String listToString(Object value) {
	    String valueString;
	    StringBuilder sb = new StringBuilder();
	    for (Object o : (Collection<?>) value) {
		if (sb.length() > 0) {
		    sb.append(",");
		}
		sb.append(o.toString());
	    }
	    valueString = sb.toString();
	    return valueString;
	}
    }

}
