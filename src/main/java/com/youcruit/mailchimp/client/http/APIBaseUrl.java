package com.youcruit.mailchimp.client.http;

import java.net.URI;
import java.util.Locale;

public enum APIBaseUrl {
    US1, US2, US3, US4, US5, US6, US7, US8, US9, US10, US11, US12;
    
    private final String API_BASE_URL = "https://%s.api.mailchimp.com/3.0";
    
    public URI getUri() {
	return URI.create(String.format(Locale.US, API_BASE_URL, this.name().toLowerCase()));
    }
}
