package com.youcruit.mailchimp.client.objects.pojos.request.list;

import java.util.Map;

import com.google.gson.annotations.SerializedName;
import com.youcruit.mailchimp.client.objects.pojos.list.ListMemberStatus;

public class ListCreateMemberRequest {
    
    @SerializedName("email_type")
    public String emailType;
    public ListMemberStatus status;
    @SerializedName("merge_fields")
    public Map<String, String> mergeFields;
    public Map<String, String> interests;
    public String language;
    public Boolean vip;
    public ListMemberCreateLocationRequest location;
    @SerializedName("email_address")
    public String emailAddress;

}
