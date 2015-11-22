package com.youcruit.mailchimp.client.objects.pojos.batch.operation;

import com.youcruit.mailchimp.client.http.HttpClient.Method;
import com.youcruit.mailchimp.client.objects.pojos.Operation.Path;
import com.youcruit.mailchimp.client.objects.pojos.OperationCreater;
import com.youcruit.mailchimp.client.objects.pojos.request.AbstractRequest;
import com.youcruit.mailchimp.client.objects.pojos.response.batch.BatchResponse;

public class BatchOperation extends OperationCreater<BatchResponse> {

    public BatchOperation(AbstractRequest request) {
	super(BatchResponse.class);
	operationBuilder.method(Method.POST).path(Path.BATCHES).body(request);
    }
}
