package com.youcruit.mailchimp.client.objects.pojos.operation.list;

import com.youcruit.mailchimp.client.http.HttpClient.Method;
import com.youcruit.mailchimp.client.objects.pojos.Operation.Path;
import com.youcruit.mailchimp.client.objects.pojos.OperationCreater;
import com.youcruit.mailchimp.client.objects.pojos.request.AbstractRequest;
import com.youcruit.mailchimp.client.objects.pojos.response.list.ListMemberResponse;

public class CreateListMemberOperation extends OperationCreater<ListMemberResponse> {

    public CreateListMemberOperation(String listId, AbstractRequest request) {
	this(listId, null, request);
    }

    public CreateListMemberOperation(String listId, String operationId, AbstractRequest request) {
	super(ListMemberResponse.class);
	operationBuilder.method(Method.PUT).operationId(operationId).body(request).path(Path.LISTS).path(listId).path(Path.MEMBERS);
    }
}
