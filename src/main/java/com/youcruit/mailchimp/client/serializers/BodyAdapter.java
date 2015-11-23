package com.youcruit.mailchimp.client.serializers;

import java.io.IOException;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;
import com.youcruit.mailchimp.client.objects.pojos.request.AbstractRequest;

public class BodyAdapter extends TypeAdapter<AbstractRequest> {

    private Gson gson;

    public BodyAdapter() {
	gson = new GsonBuilder().create();
    }

    @Override
    public void write(JsonWriter out, AbstractRequest value) throws IOException {
	if (value != null) {
	    out.value(gson.toJson(value));
	} else {
	    out.nullValue();
	}
    }

    @Override
    public AbstractRequest read(JsonReader in) throws IOException {
	throw new IllegalArgumentException("Not implemented");
    }

}
