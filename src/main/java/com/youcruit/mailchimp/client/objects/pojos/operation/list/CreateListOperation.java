package com.youcruit.mailchimp.client.objects.pojos.operation.list;

import com.youcruit.mailchimp.client.http.HttpClient.Method;
import com.youcruit.mailchimp.client.objects.pojos.Operation.Path;
import com.youcruit.mailchimp.client.objects.pojos.OperationCreater;
import com.youcruit.mailchimp.client.objects.pojos.request.AbstractRequest;
import com.youcruit.mailchimp.client.objects.pojos.response.list.ListResponse;

public class CreateListOperation extends OperationCreater<ListResponse> {

    public CreateListOperation(AbstractRequest request) {
	this(null, request);
    }

    public CreateListOperation(String operationId, AbstractRequest abstractRequest) {
	super(ListResponse.class);
	operationBuilder.method(Method.POST).operationId(operationId).path(Path.LISTS).body(abstractRequest);
    }

}
