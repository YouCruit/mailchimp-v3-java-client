package com.youcruit.mailchimp.client.serializers;

import java.io.IOException;
import java.lang.reflect.Field;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.TypeAdapter;
import com.google.gson.annotations.SerializedName;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;
import com.youcruit.mailchimp.client.objects.pojos.QueryParameters;

public class QueryParametersAdapter extends TypeAdapter<QueryParameters> {

    @Override
    public QueryParameters read(JsonReader in) throws IOException {
	throw new RuntimeException("Not implemented");
    }

    @Override
    public void write(JsonWriter out, QueryParameters queryParameters) throws IOException {
	Gson gson = new GsonBuilder().create();
	String json = gson.toJson(toQueryParameters(queryParameters));
	out.value(json);
    }

    public Map<String, String> toQueryParameters(QueryParameters queryParameters) {
	Map<String, String> result = new HashMap<>();
	if (queryParameters != null) {
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
