package com.youcruit.mailchimp.client.objects.pojos.operation.list;

import com.youcruit.mailchimp.client.http.HttpClient.Method;
import com.youcruit.mailchimp.client.objects.pojos.Operation.Path;
import com.youcruit.mailchimp.client.objects.pojos.OperationCreater;
import com.youcruit.mailchimp.client.serializers.MD5TypeAdapter;

public class DeleteListMemberOperation extends OperationCreater<Void> {

    public DeleteListMemberOperation(String listId, String email) {
	this(listId, email, null);
    }

    public DeleteListMemberOperation(String listId, String email, String operationId) {
	super(Void.class);
	operationBuilder.method(Method.DELETE).operationId(operationId).path(Path.LISTS).path(listId).path(Path.MEMBERS).path(new MD5TypeAdapter().toMD5LowerCase(email));
    }
}
