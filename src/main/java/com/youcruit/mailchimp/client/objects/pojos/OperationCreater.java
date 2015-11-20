package com.youcruit.mailchimp.client.objects.pojos;

import com.youcruit.mailchimp.client.objects.pojos.Operation.OperationBuilder;

public abstract class OperationCreater<T> {
    protected OperationBuilder operationBuilder;
    protected final Class<T> responseClass;

    public OperationCreater(Class<T> clazz) {
        this.responseClass = clazz;
    }

    public Operation createOperation() {
	return operationBuilder.createOperation(responseClass);
    }
}
