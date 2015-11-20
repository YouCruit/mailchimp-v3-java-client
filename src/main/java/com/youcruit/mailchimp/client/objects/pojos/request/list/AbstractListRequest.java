package com.youcruit.mailchimp.client.objects.pojos.request.list;

import java.util.List;

import com.google.gson.annotations.SerializedName;
import com.youcruit.mailchimp.client.objects.pojos.QueryParameters;
import com.youcruit.mailchimp.client.objects.pojos.request.AbstractRequest;

public abstract class AbstractListRequest implements QueryParameters, AbstractRequest {
    
    public List<String> fields;
    @SerializedName("exclude_fields")
    public List<String> excludedFields;

}
