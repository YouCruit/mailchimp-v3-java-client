package com.youcruit.mailchimp.client.objects.pojos.request.list;

import java.util.ArrayList;
import java.util.List;

import com.youcruit.mailchimp.client.objects.pojos.Operation;

public class ListBatchRequest {

    public List<Operation<?>> operations = new ArrayList<>(); 

}
