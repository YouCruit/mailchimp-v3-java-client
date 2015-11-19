package com.youcruit.mailchimp.client.objects.pojos.request.list;

import java.util.Date;

import com.google.gson.annotations.SerializedName;

public class ListMembersRequest extends AbstractListRequest {

    public Integer count;
    public Integer offset;
    @SerializedName("email_type")
    public String emailType;
    public String status;
    @SerializedName("since_timestamp_opt")
    public Date sinceTimestampOpt;
    @SerializedName("before_timestamp_opt")
    public Date beforeTimestampOpt;
    @SerializedName("since_last_changed")
    public Date sinceLastChanged;
    @SerializedName("before_last_changed")
    public Date beforeLastChanged;
}
