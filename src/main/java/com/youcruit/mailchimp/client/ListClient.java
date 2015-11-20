package com.youcruit.mailchimp.client;

import java.io.IOException;

import com.youcruit.mailchimp.client.http.HttpClient;
import com.youcruit.mailchimp.client.objects.pojos.OperationCreater;
import com.youcruit.mailchimp.client.objects.pojos.list.operation.CreateListMemberOperation;
import com.youcruit.mailchimp.client.objects.pojos.list.operation.CreateListOperation;
import com.youcruit.mailchimp.client.objects.pojos.list.operation.DeleteListMemberOperation;
import com.youcruit.mailchimp.client.objects.pojos.list.operation.GetListMemberOperation;
import com.youcruit.mailchimp.client.objects.pojos.list.operation.GetListMembersOperation;
import com.youcruit.mailchimp.client.objects.pojos.list.operation.GetListOperation;
import com.youcruit.mailchimp.client.objects.pojos.list.operation.GetListsOperation;
import com.youcruit.mailchimp.client.objects.pojos.response.list.ListMemberResponse;
import com.youcruit.mailchimp.client.objects.pojos.response.list.ListMembersResponse;
import com.youcruit.mailchimp.client.objects.pojos.response.list.ListResponse;
import com.youcruit.mailchimp.client.objects.pojos.response.list.ListsResponse;

public class ListClient {

    private final HttpClient httpClient;

    public ListClient(final HttpClient httpClient) {
	this.httpClient = httpClient;
    }

    public ListsResponse getLists(GetListsOperation operation) throws IOException {
	return call(operation);
    }

    public ListResponse getList(GetListOperation operation) throws IOException {
	return call(operation);
    }

    public ListResponse createList(CreateListOperation operation) throws IOException {
	return call(operation);
    }

    public ListMembersResponse getListMembers(GetListMembersOperation operation) throws IOException {
	return call(operation);
    }

    public ListMemberResponse getListMember(GetListMemberOperation operation) throws IOException {
	return call(operation);
    }

    public ListMemberResponse createListMember(CreateListMemberOperation operation) throws IOException {
	return call(operation);
    }
    
    public void deleteListMember(DeleteListMemberOperation operation) throws IOException {
	call(operation);
    }
    
    private <V> V call(OperationCreater operationCreater) throws IOException {
	return httpClient.sync(operationCreater.createOperation());
    }
}