package com.youcruit.mailchimp.client.objects.pojos.response.list;

import java.math.BigDecimal;
import java.util.Date;

import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import com.youcruit.mailchimp.client.serializers.RFC3339TypeAdapter;

public class ListStatsResponse {

    @SerializedName("member_count")
    public Integer memberCount;
    @SerializedName("unsubscribe_count")
    public Integer unsubscribeCount;
    @SerializedName("cleaned_count")
    public Integer cleanedCount;
    @SerializedName("member_count_since_send")
    public Integer memberCountSinceSend;
    @SerializedName("unsubscribe_count_since_send")
    public Integer unsubscribeCountSinceSend;
    @SerializedName("cleaned_count_since_send")
    public Integer cleanedCountSinceSend;
    @SerializedName("campaign_count")
    public Integer campaignCount;
    @SerializedName("campaign_last_sent")
    @JsonAdapter(RFC3339TypeAdapter.class)
    public Date campaignLastSent;
    @SerializedName("merge_field_count")
    public String mergeFieldCount;
    @SerializedName("avg_sub_rate")
    public BigDecimal avgSubRate;
    @SerializedName("avg_unsub_rate")
    public BigDecimal avgUnsubRate;
    @SerializedName("target_sub_rate")
    public BigDecimal targetSubRate;
    @SerializedName("open_rate")
    public BigDecimal openRate;
    @SerializedName("click_rate")
    public BigDecimal clickRate;
    @SerializedName("last_sub_date")
    @JsonAdapter(RFC3339TypeAdapter.class)
    public Date lastSubDate;
    @SerializedName("last_unsub_date")
    @JsonAdapter(RFC3339TypeAdapter.class)
    public Date lastUnsubDate;

}
