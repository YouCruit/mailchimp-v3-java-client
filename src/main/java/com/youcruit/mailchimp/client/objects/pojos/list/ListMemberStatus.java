package com.youcruit.mailchimp.client.objects.pojos.list;

import com.google.gson.annotations.SerializedName;

public enum ListMemberStatus {

    @SerializedName("subscribed")
    SUBSCRIBED, //
    @SerializedName("unsubscribed")
    UNSUBSCRIBED, //
    @SerializedName("cleaned")
    CLEANED, //
    @SerializedName("pending")
    PENDING

}
