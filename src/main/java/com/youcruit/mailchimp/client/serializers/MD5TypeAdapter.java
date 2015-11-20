package com.youcruit.mailchimp.client.serializers;

import java.io.IOException;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Locale;

import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.JsonWriter;
import com.youcruit.mailchimp.client.http.HttpClient;

public class MD5TypeAdapter extends TypeAdapter<String> {

    @Override
    public String read(JsonReader in) throws IOException {
	final JsonToken peek = in.peek();
	if (peek == JsonToken.NULL) {
	    in.nextNull();
	    return null;
	} else {
	    return in.nextString();
	}
    }

    @Override
    public void write(JsonWriter out, String value) throws IOException {
	if (value != null) {
	    out.value(toMD5LowerCase(value));
	} else {
	    out.nullValue();
	}
    }

    public String toMD5LowerCase(String input) {
	try {
	    MessageDigest md5 = MessageDigest.getInstance("MD5");
	    md5.update(input.toLowerCase(Locale.US).getBytes(HttpClient.UTF8));
	    return String.format("%032x", new BigInteger(1, md5.digest()));
	} catch (NoSuchAlgorithmException e) {
	    throw new RuntimeException(e);
	}
    }

}
