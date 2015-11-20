package com.youcruit.mailchimp.client.objects.pojos.batch;

import com.google.gson.annotations.SerializedName;

public enum BatchStatus {

    @SerializedName("pending")
    PENDING, //
    @SerializedName("started")
    STARTED, //
    @SerializedName("finished")
    FINISHED, //

}
