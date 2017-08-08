package com.youcruit.mailchimp.client.objects.pojos.operation.list;

import com.youcruit.mailchimp.client.http.HttpClient.Method;
import com.youcruit.mailchimp.client.objects.pojos.Operation.Path;
import com.youcruit.mailchimp.client.objects.pojos.OperationCreater;
import com.youcruit.mailchimp.client.objects.pojos.request.AbstractRequest;
import com.youcruit.mailchimp.client.objects.pojos.response.list.ListMemberResponse;
import com.youcruit.mailchimp.client.serializers.MD5TypeAdapter;

public class UpsertListMemberOperation extends OperationCreater<ListMemberResponse> {

    public UpsertListMemberOperation(String listId, String email, AbstractRequest request) {
	this(listId, null, email, request);
    }

    public UpsertListMemberOperation(String listId, String operationId, String email, AbstractRequest request) {
	super(ListMemberResponse.class);
	operationBuilder.method(Method.PUT).operationId(operationId).body(request).path(Path.LISTS).path(listId).path(Path.MEMBERS).path(new MD5TypeAdapter().toMD5LowerCase(email));
    }
}
