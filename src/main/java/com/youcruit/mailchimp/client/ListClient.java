package com.youcruit.mailchimp.client;

import java.io.IOException;

import com.youcruit.mailchimp.client.http.HttpClient;
import com.youcruit.mailchimp.client.http.HttpClient.Method;
import com.youcruit.mailchimp.client.objects.pojos.request.list.ListRequest;
import com.youcruit.mailchimp.client.objects.pojos.request.list.ListsRequest;
import com.youcruit.mailchimp.client.objects.pojos.response.list.ListResponse;
import com.youcruit.mailchimp.client.objects.pojos.response.list.ListsResponse;

public class ListClient {

    private final HttpClient httpClient;

    public ListClient(final HttpClient httpClient) {
	this.httpClient = httpClient;
    }

    public ListsResponse getLists(ListsRequest request) throws IOException {
	return httpClient.sync(Method.GET, ListsResponse.class, httpClient.toQueryParameters(request), "lists");
    }
    
    public ListResponse getList(String id, ListRequest request) throws IOException {
	return httpClient.sync(Method.GET, ListResponse.class, httpClient.toQueryParameters(request), "lists", id);
    }

}