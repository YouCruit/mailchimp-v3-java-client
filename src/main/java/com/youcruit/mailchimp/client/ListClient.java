package com.youcruit.mailchimp.client;

import java.io.IOException;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Locale;

import com.youcruit.mailchimp.client.http.HttpClient;
import com.youcruit.mailchimp.client.http.HttpClient.Method;
import com.youcruit.mailchimp.client.objects.pojos.request.list.ListMemberRequest;
import com.youcruit.mailchimp.client.objects.pojos.request.list.ListMembersRequest;
import com.youcruit.mailchimp.client.objects.pojos.request.list.ListRequest;
import com.youcruit.mailchimp.client.objects.pojos.request.list.ListsRequest;
import com.youcruit.mailchimp.client.objects.pojos.response.list.ListMemberResponse;
import com.youcruit.mailchimp.client.objects.pojos.response.list.ListMembersResponse;
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

    public ListMembersResponse getListMembers(String id, ListMembersRequest request) throws IOException {
	return httpClient.sync(Method.GET, ListMembersResponse.class, httpClient.toQueryParameters(request), "lists", id, "members");
    }

    public ListMemberResponse getListMember(String id, String email, ListMemberRequest request) throws IOException {
	return httpClient.sync(Method.GET, ListMemberResponse.class, httpClient.toQueryParameters(request), "lists", id, "members", md5LowerCase(email));
    }

    private String md5LowerCase(String s) {
	try {
	    MessageDigest md5 = MessageDigest.getInstance("MD5");
	    md5.update(s.toLowerCase(Locale.US).getBytes(HttpClient.UTF8));
	    return String.format("%032x", new BigInteger(1, md5.digest()));
	} catch (NoSuchAlgorithmException e) {
	    throw new RuntimeException(e);
	}
    }

}