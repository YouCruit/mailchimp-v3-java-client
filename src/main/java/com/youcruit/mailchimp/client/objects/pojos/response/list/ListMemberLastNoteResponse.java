package com.youcruit.mailchimp.client.objects.pojos.response.list;

import java.util.Date;

import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import com.youcruit.mailchimp.client.serializers.RFC3339TypeAdapter;

public class ListMemberLastNoteResponse {

    @SerializedName("note_id")
    public Integer noteId;
    
    @SerializedName("created_at")
    @JsonAdapter(RFC3339TypeAdapter.class)
    public Date created_at;
    
    @SerializedName("created_by")
    public Integer createdBy;
    
    public Integer note;

}
