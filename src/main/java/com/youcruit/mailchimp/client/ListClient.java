package com.youcruit.mailchimp.client;

import java.io.IOException;

import com.youcruit.mailchimp.client.http.HttpClient;
import com.youcruit.mailchimp.client.http.HttpClient.Method;
import com.youcruit.mailchimp.client.objects.pojos.request.list.CreateListRequest;
import com.youcruit.mailchimp.client.objects.pojos.request.list.GetListRequest;
import com.youcruit.mailchimp.client.objects.pojos.request.list.ListCreateMemberRequest;
import com.youcruit.mailchimp.client.objects.pojos.request.list.ListMemberRequest;
import com.youcruit.mailchimp.client.objects.pojos.request.list.ListMembersRequest;
import com.youcruit.mailchimp.client.objects.pojos.request.list.ListsRequest;
import com.youcruit.mailchimp.client.objects.pojos.response.list.ListMemberResponse;
import com.youcruit.mailchimp.client.objects.pojos.response.list.ListMembersResponse;
import com.youcruit.mailchimp.client.objects.pojos.response.list.ListResponse;
import com.youcruit.mailchimp.client.objects.pojos.response.list.ListsResponse;
import com.youcruit.mailchimp.client.serializers.MD5TypeAdapter;

public class ListClient {

    private final HttpClient httpClient;

    public ListClient(final HttpClient httpClient) {
	this.httpClient = httpClient;
    }

    public ListsResponse getLists(ListsRequest request) throws IOException {
	return httpClient.sync(Method.GET, ListsResponse.class, httpClient.toQueryParameters(request), "lists");
    }
    
    public ListResponse createList(CreateListRequest request) throws IOException {
	return httpClient.sync(request, Method.POST, ListResponse.class, "lists");
    }

    public ListResponse getList(String id, GetListRequest request) throws IOException {
	return httpClient.sync(Method.GET, ListResponse.class, httpClient.toQueryParameters(request), "lists", id);
    }

    public ListMembersResponse getListMembers(String id, ListMembersRequest request) throws IOException {
	return httpClient.sync(Method.GET, ListMembersResponse.class, httpClient.toQueryParameters(request), "lists", id, "members");
    }

    public ListMemberResponse getListMember(String id, String email, ListMemberRequest request) throws IOException {
	return httpClient.sync(Method.GET, ListMemberResponse.class, httpClient.toQueryParameters(request), "lists", id, "members", new MD5TypeAdapter().toMD5LowerCase(email));
    }

    public ListMemberResponse createListMember(String id, ListCreateMemberRequest request) throws IOException {
	return httpClient.sync(request, Method.POST, ListMemberResponse.class, "lists", id, "members");
    }

    public void deleteListMember(String id, String email) throws IOException {
	httpClient.sync(Method.DELETE, Void.class, "lists", id, "members", new MD5TypeAdapter().toMD5LowerCase(email));
    }

}