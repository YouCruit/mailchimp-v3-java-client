package com.youcruit.mailchimp.client.objects.pojos.request.list;

import java.util.Date;

import com.google.gson.annotations.SerializedName;

public class ListsRequest extends AbstractListRequest {

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
