package com.youcruit.mailchimp.client.objects.pojos.operation.list;

import com.youcruit.mailchimp.client.http.HttpClient.Method;
import com.youcruit.mailchimp.client.objects.pojos.Operation.Path;
import com.youcruit.mailchimp.client.objects.pojos.OperationCreater;
import com.youcruit.mailchimp.client.objects.pojos.QueryParameters;
import com.youcruit.mailchimp.client.objects.pojos.response.list.ListMemberResponse;
import com.youcruit.mailchimp.client.serializers.MD5TypeAdapter;

public class GetListMemberOperation extends OperationCreater<ListMemberResponse> {

    public GetListMemberOperation(String listId, String email) {
	this(listId, email, null);
    }

    public GetListMemberOperation(String listId, String email, QueryParameters queryParameters) {
	this(listId, email, null, queryParameters);
    }

    public GetListMemberOperation(String listId, String email, String operationId, QueryParameters queryParameters) {
	super(ListMemberResponse.class);
	operationBuilder.method(Method.GET).operationId(operationId).params(queryParameters).path(Path.LISTS).path(listId).path(Path.MEMBERS).path(new MD5TypeAdapter().toMD5LowerCase(email));
    }
}
