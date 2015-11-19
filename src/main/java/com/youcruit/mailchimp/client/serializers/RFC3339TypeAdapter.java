package com.youcruit.mailchimp.client.serializers;

import java.util.TimeZone;

public class RFC3339TypeAdapter extends GenericDateTypeAdapter{
    public RFC3339TypeAdapter() {
	super("yyyy-MM-dd'T'HH:mm:ssXXX", TimeZone.getTimeZone("UTC"));
    }
}
