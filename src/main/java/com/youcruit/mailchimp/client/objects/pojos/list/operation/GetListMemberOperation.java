package com.youcruit.mailchimp.client.objects.pojos.list.operation;

import com.youcruit.mailchimp.client.http.HttpClient.Method;
import com.youcruit.mailchimp.client.objects.pojos.Operation.OperationBuilder;
import com.youcruit.mailchimp.client.objects.pojos.Operation.Path;
import com.youcruit.mailchimp.client.objects.pojos.OperationCreater;
import com.youcruit.mailchimp.client.objects.pojos.QueryParameters;
import com.youcruit.mailchimp.client.objects.pojos.response.list.ListMemberResponse;
import com.youcruit.mailchimp.client.serializers.MD5TypeAdapter;

public class GetListMemberOperation extends OperationCreater {

    public GetListMemberOperation(String listId, String email) {
	this(listId, email, null);
    }

    public GetListMemberOperation(String listId, String email, QueryParameters queryParameters) {
	this(listId, email, null, queryParameters);
    }

    public GetListMemberOperation(String listId, String email, String operationId, QueryParameters queryParameters) {
	operationBuilder = new OperationBuilder();
	operationBuilder.method(Method.GET);
	operationBuilder.operationId(operationId);
	operationBuilder.params(queryParameters);
	operationBuilder.path(Path.LISTS);
	operationBuilder.path(listId);
	operationBuilder.path(Path.MEMBERS);
	operationBuilder.path(new MD5TypeAdapter().toMD5LowerCase(email));
	operationBuilder.responseClass(ListMemberResponse.class);
    }
}
