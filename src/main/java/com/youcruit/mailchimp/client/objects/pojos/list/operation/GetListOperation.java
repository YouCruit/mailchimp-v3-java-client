package com.youcruit.mailchimp.client.objects.pojos.list.operation;

import com.youcruit.mailchimp.client.http.HttpClient.Method;
import com.youcruit.mailchimp.client.objects.pojos.Operation.OperationBuilder;
import com.youcruit.mailchimp.client.objects.pojos.Operation.Path;
import com.youcruit.mailchimp.client.objects.pojos.OperationCreater;
import com.youcruit.mailchimp.client.objects.pojos.QueryParameters;
import com.youcruit.mailchimp.client.objects.pojos.response.list.ListResponse;

public class GetListOperation extends OperationCreater {

    public GetListOperation(String listId) {
	this(listId, null);
    }

    public GetListOperation(String listId, QueryParameters queryParameters) {
	this(listId, null, queryParameters);
    }

    public GetListOperation(String listId, String operationId, QueryParameters queryParameters) {
	operationBuilder = new OperationBuilder();
	operationBuilder.method(Method.GET);
	operationBuilder.operationId(operationId);
	operationBuilder.params(queryParameters);
	operationBuilder.path(Path.LISTS);
	operationBuilder.path(listId);
	operationBuilder.responseClass(ListResponse.class);
    }

}
