package com.youcruit.mailchimp.client.serializers;

import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;

import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.JsonWriter;

public class GenericDateTypeAdapter extends TypeAdapter<Date> {

    private final String format;
    private final TimeZone timezone;

    public GenericDateTypeAdapter(String format, TimeZone timezone) {
	this.format = format;
	this.timezone = timezone;
    }

    @Override
    public void write(JsonWriter out, Date value) throws IOException {
	if (value != null) {
	    String stringValue = getDateFormat().format(value);
	    out.value(stringValue);
	} else {
	    out.nullValue();
	}

    }

    public DateFormat getDateFormat() {
	final SimpleDateFormat simpleDateFormat = new SimpleDateFormat(format, Locale.US);
	simpleDateFormat.setTimeZone(timezone);
	return simpleDateFormat;
    }

    @Override
    public Date read(JsonReader in) throws IOException {
	final JsonToken peek = in.peek();
	if (peek == JsonToken.NULL) {
	    in.nextNull();
	    return null;
	} else {
	    String stringValue = in.nextString();
	    try {
		return getDateFormat().parse(stringValue);
	    } catch (ParseException e) {
		throw new IOException(e);
	    }
	}
    }
}
