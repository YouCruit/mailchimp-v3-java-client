package com.youcruit.mailchimp.client.objects.pojos.operation.list;

import com.youcruit.mailchimp.client.http.HttpClient.Method;
import com.youcruit.mailchimp.client.objects.pojos.Operation.Path;
import com.youcruit.mailchimp.client.objects.pojos.OperationCreater;
import com.youcruit.mailchimp.client.objects.pojos.QueryParameters;
import com.youcruit.mailchimp.client.objects.pojos.response.list.ListMembersResponse;

public class GetListMembersOperation extends OperationCreater<ListMembersResponse> {

    public GetListMembersOperation(String listId) {
	this(listId, null);
    }

    public GetListMembersOperation(String listId, QueryParameters queryParameters) {
	this(listId, null, queryParameters);
    }

    public GetListMembersOperation(String listId, String operationId, QueryParameters queryParameters) {
	super(ListMembersResponse.class);
	operationBuilder.method(Method.GET).operationId(operationId).params(queryParameters).path(Path.LISTS).path(listId).path(Path.MEMBERS);
    }
}
