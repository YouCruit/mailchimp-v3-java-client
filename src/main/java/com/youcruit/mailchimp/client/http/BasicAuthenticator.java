package com.youcruit.mailchimp.client.http;

import java.io.IOException;
import java.net.Proxy;

import com.squareup.okhttp.Authenticator;
import com.squareup.okhttp.Credentials;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.Response;

public class BasicAuthenticator implements Authenticator {

    private final String username;
    private final String password;

    public BasicAuthenticator(String username, String password) {
	this.username = username;
	this.password = password;
    }

    @Override
    public Request authenticate(Proxy proxy, Response response) throws IOException {
	final String credential = Credentials.basic(username, password);
	return response.request().newBuilder().header("Authorization", credential).build();
    }

    @Override
    public Request authenticateProxy(Proxy proxy, Response response) throws IOException {
	return null;
    }
}
