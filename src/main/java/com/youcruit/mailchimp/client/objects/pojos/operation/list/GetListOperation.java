package com.youcruit.mailchimp.client.objects.pojos.operation.list;

import com.youcruit.mailchimp.client.http.HttpClient.Method;
import com.youcruit.mailchimp.client.objects.pojos.Operation.OperationBuilder;
import com.youcruit.mailchimp.client.objects.pojos.Operation.Path;
import com.youcruit.mailchimp.client.objects.pojos.OperationCreater;
import com.youcruit.mailchimp.client.objects.pojos.QueryParameters;
import com.youcruit.mailchimp.client.objects.pojos.response.list.ListResponse;

public class GetListOperation extends OperationCreater<ListResponse> {

    public GetListOperation(String listId) {
	this(listId, null);
    }

    public GetListOperation(String listId, QueryParameters queryParameters) {
	this(listId, null, queryParameters);
    }

    public GetListOperation(String listId, String operationId, QueryParameters queryParameters) {
	super(ListResponse.class);
	operationBuilder = new OperationBuilder().method(Method.GET).operationId(operationId).params(queryParameters).path(Path.LISTS).path(listId);
    }

}
