package com.youcruit.mailchimp.client.objects.pojos;

import com.youcruit.mailchimp.client.objects.pojos.Operation.OperationBuilder;

public abstract class OperationCreater {
    protected OperationBuilder operationBuilder;

    public Operation createOperation() {
	return operationBuilder.createOperation();
    }
}
