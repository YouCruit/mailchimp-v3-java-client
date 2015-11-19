package com.youcruit.mailchimp.client;

import java.util.logging.Logger;

import com.youcruit.mailchimp.client.http.APIBaseUrl;
import com.youcruit.mailchimp.client.http.HttpClient;
import com.youcruit.mailchimp.client.http.OkHttpClient;

public abstract class HttpIT {

    public static final Logger LOGGER = Logger.getLogger("HttpTest");
    protected final HttpClient client;

    public HttpIT() {
	client = new OkHttpClient(getPropEnv("MAILCHIMP_PASSWORD"), APIBaseUrl.valueOf(getPropEnv("MAILCHIMP_DC")).getUri());
    }

    public String getPropEnv(String key) {
	String value = System.getProperties().getProperty(key);
	if (value == null) {
	    value = System.getenv(key);
	}
	return value;
    }
}
