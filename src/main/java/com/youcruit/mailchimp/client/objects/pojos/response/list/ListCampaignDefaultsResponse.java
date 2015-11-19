package com.youcruit.mailchimp.client.objects.pojos.response.list;

import com.google.gson.annotations.SerializedName;

public class ListCampaignDefaultsResponse {

    @SerializedName("from_name")
    public String fromName;
    @SerializedName("from_email")
    public String fromEmail;
    public String subject;
    public String language;

}
