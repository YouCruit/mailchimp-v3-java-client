package com.youcruit.mailchimp.client.objects.pojos.response.batch;

import java.util.Date;

import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import com.youcruit.mailchimp.client.objects.pojos.batch.BatchStatus;
import com.youcruit.mailchimp.client.serializers.DateTimeAdapter;

public class BatchResponse {

    public String id;
    public BatchStatus status;
    @SerializedName("total_operations")
    public Integer totalOperations;
    @SerializedName("finished_operations")
    public Integer finishedOperations;
    @SerializedName("errored_operations")
    public Integer erroredOperations;
    @SerializedName("submitted_at")
    @JsonAdapter(DateTimeAdapter.class)
    public Date submittedAt;
    @SerializedName("completed_at")
    @JsonAdapter(DateTimeAdapter.class)
    public Date completedAt;
    @SerializedName("response_body_url")
    public String responseBodyUrl;
}
