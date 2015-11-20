package com.youcruit.mailchimp.client.objects.pojos.list.operation;

import com.youcruit.mailchimp.client.http.HttpClient.Method;
import com.youcruit.mailchimp.client.objects.pojos.Operation.OperationBuilder;
import com.youcruit.mailchimp.client.objects.pojos.Operation.Path;
import com.youcruit.mailchimp.client.objects.pojos.OperationCreater;
import com.youcruit.mailchimp.client.objects.pojos.request.AbstractRequest;
import com.youcruit.mailchimp.client.objects.pojos.response.list.ListResponse;

public class CreateListOperation extends OperationCreater {

    public CreateListOperation(AbstractRequest request) {
	this(null, request);
    }

    public CreateListOperation(String operationId, AbstractRequest abstractRequest) {
	operationBuilder = new OperationBuilder();
	operationBuilder.method(Method.POST);
	operationBuilder.operationId(operationId);
	operationBuilder.path(Path.LISTS);
	operationBuilder.body(abstractRequest);
	operationBuilder.responseClass(ListResponse.class);
    }

}
