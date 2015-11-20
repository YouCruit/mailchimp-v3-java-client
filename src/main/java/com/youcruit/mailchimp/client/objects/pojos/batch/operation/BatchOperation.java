package com.youcruit.mailchimp.client.objects.pojos.batch.operation;

import com.youcruit.mailchimp.client.http.HttpClient.Method;
import com.youcruit.mailchimp.client.objects.pojos.Operation.OperationBuilder;
import com.youcruit.mailchimp.client.objects.pojos.Operation.Path;
import com.youcruit.mailchimp.client.objects.pojos.OperationCreater;
import com.youcruit.mailchimp.client.objects.pojos.request.AbstractRequest;
import com.youcruit.mailchimp.client.objects.pojos.response.batch.BatchResponse;

public class BatchOperation extends OperationCreater {

    public BatchOperation(AbstractRequest request) {
	operationBuilder = new OperationBuilder();
	operationBuilder.method(Method.POST);
	operationBuilder.path(Path.BATCHES);
	operationBuilder.body(request);
	operationBuilder.responseClass(BatchResponse.class);
    }
}
