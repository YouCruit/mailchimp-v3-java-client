package com.youcruit.mailchimp.client.objects.pojos.operation.list;

import com.youcruit.mailchimp.client.http.HttpClient.Method;
import com.youcruit.mailchimp.client.objects.pojos.Operation.OperationBuilder;
import com.youcruit.mailchimp.client.objects.pojos.Operation.Path;
import com.youcruit.mailchimp.client.objects.pojos.OperationCreater;
import com.youcruit.mailchimp.client.objects.pojos.QueryParameters;
import com.youcruit.mailchimp.client.objects.pojos.response.list.ListsResponse;

public class GetListsOperation extends OperationCreater<ListsResponse> {

    public GetListsOperation() {
	this(null);
    }

    public GetListsOperation(QueryParameters queryParameters) {
	this(null, queryParameters);
    }

    public GetListsOperation(String operationId, QueryParameters queryParameters) {
	super(ListsResponse.class);
	operationBuilder = new OperationBuilder();
	operationBuilder.method(Method.GET);
	operationBuilder.operationId(operationId);
	operationBuilder.params(queryParameters);
	operationBuilder.path(Path.LISTS);
    }

}
