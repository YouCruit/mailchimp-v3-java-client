package com.youcruit.mailchimp.client.objects.pojos.request.list;

import com.google.gson.annotations.SerializedName;
import com.youcruit.mailchimp.client.objects.pojos.request.AbstractRequest;

public class ListCreateCampaignDefaultsRequest implements AbstractRequest {
    
    @SerializedName("from_name")
    public String fromName;
    @SerializedName("from_email")
    public String fromEmail;
    public String subject;
    public String language;

}
