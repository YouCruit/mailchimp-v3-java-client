package com.youcruit.mailchimp.client.serializers;

import java.io.IOException;

import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;

public class ArrayStringAdapter extends TypeAdapter<String[]> {

    @Override
    public String[] read(JsonReader in) throws IOException {
	throw new IllegalArgumentException("Not implemented");
    }

    @Override
    public void write(JsonWriter out, String[] value) throws IOException {
	if (value != null) {
	    out.value(listToString(value));
	} else {
	    out.nullValue();
	}
    }
    
    public String listToString(String[] value) {
	StringBuilder sb = new StringBuilder();
	for (String s : value) {
	    if (sb.length() > 0) {
		sb.append("/").append(s);
	    }
	}
	return sb.toString();
    }

}
