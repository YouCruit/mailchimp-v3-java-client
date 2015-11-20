package com.youcruit.mailchimp.client.objects.pojos.operation.list;

import com.youcruit.mailchimp.client.http.HttpClient.Method;
import com.youcruit.mailchimp.client.objects.pojos.Operation.OperationBuilder;
import com.youcruit.mailchimp.client.objects.pojos.Operation.Path;
import com.youcruit.mailchimp.client.objects.pojos.OperationCreater;
import com.youcruit.mailchimp.client.objects.pojos.request.AbstractRequest;
import com.youcruit.mailchimp.client.objects.pojos.response.list.ListMemberResponse;

public class CreateListMemberOperation extends OperationCreater {

    public CreateListMemberOperation(String listId, AbstractRequest request) {
	this(listId, null, request);
    }

    public CreateListMemberOperation(String listId, String operationId, AbstractRequest request) {
	operationBuilder = new OperationBuilder();
	operationBuilder.method(Method.POST);
	operationBuilder.operationId(operationId);
	operationBuilder.body(request);
	operationBuilder.path(Path.LISTS);
	operationBuilder.path(listId);
	operationBuilder.path(Path.MEMBERS);
	operationBuilder.responseClass(ListMemberResponse.class);
    }
}
