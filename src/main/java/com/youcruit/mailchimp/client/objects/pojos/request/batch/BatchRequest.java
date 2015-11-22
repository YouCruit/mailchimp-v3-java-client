package com.youcruit.mailchimp.client.objects.pojos.request.batch;

import java.util.ArrayList;
import java.util.List;

import com.youcruit.mailchimp.client.objects.pojos.Operation;
import com.youcruit.mailchimp.client.objects.pojos.OperationCreater;
import com.youcruit.mailchimp.client.objects.pojos.request.AbstractRequest;

public class BatchRequest implements AbstractRequest {

    public List<Operation<?>> operations;

    private BatchRequest() {
    }

    private BatchRequest(List<Operation<?>> operations) {
	this.operations = operations;
    }

    public static class BatchRequestBuilder {
	private List<Operation<?>> operations;

	public BatchRequestBuilder() {
	    this.operations = new ArrayList<>();
	}

	public BatchRequestBuilder operation(final OperationCreater<?> operation) {
	    Operation<?> createOperation = operation.createOperation();
	    //TODO exclude from JSON instead
	    createOperation.responseClass = null;
	    this.operations.add(createOperation);
	    return this;
	}

	public BatchRequest create() {
	    return new BatchRequest(operations);
	}
    }

}
