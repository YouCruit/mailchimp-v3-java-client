package com.youcruit.mailchimp.client;

import java.io.IOException;

import com.youcruit.mailchimp.client.http.HttpClient;
import com.youcruit.mailchimp.client.objects.pojos.Operation;
import com.youcruit.mailchimp.client.objects.pojos.OperationCreater;
import com.youcruit.mailchimp.client.objects.pojos.batch.operation.BatchOperation;
import com.youcruit.mailchimp.client.objects.pojos.response.batch.BatchResponse;

public class BatchClient {

    private final HttpClient httpClient;

    public BatchClient(final HttpClient httpClient) {
	this.httpClient = httpClient;
    }

    public BatchResponse batch(BatchOperation operation) throws IOException {
	return call(operation);
    }
    
    private <V> V call(OperationCreater operationCreater) throws IOException {
	Operation createOperation = operationCreater.createOperation();
	return httpClient.sync(createOperation);
    }
}