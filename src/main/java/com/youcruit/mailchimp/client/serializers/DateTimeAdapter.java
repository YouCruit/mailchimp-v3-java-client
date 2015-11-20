package com.youcruit.mailchimp.client.serializers;

import java.util.TimeZone;

public class DateTimeAdapter extends GenericDateTypeAdapter{
    public DateTimeAdapter() {
	super("yyyy-MM-dd HH:mm:ss", TimeZone.getTimeZone("UTC"));
    }
}