package com.youcruit.mailchimp.client.objects.pojos.request.list;

import java.util.Date;
import java.util.List;

import com.google.gson.annotations.SerializedName;
import com.youcruit.mailchimp.client.objects.pojos.QueryParameters;

public class ListsRequest implements QueryParameters {

    public List<String> fields;
    @SerializedName("exclude_fields")
    public List<String> excludedFields;
    public Integer count;
    public Integer offset;
    @SerializedName("before_date_created")
    public Date beforeDateCreated;
    @SerializedName("since_date_created")
    public Date sinceDateCreated;
    @SerializedName("before_campaign_last_sent")
    public Date beforeCampaignLastSent;
    @SerializedName("since_campaign_last_sent")
    public Date sinceCampaignLastSent;
}
