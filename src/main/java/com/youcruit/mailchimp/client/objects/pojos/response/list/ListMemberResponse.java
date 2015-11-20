package com.youcruit.mailchimp.client.objects.pojos.response.list;

import java.math.BigDecimal;
import java.util.Date;
import java.util.Map;

import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import com.youcruit.mailchimp.client.objects.pojos.list.ListMemberStatus;
import com.youcruit.mailchimp.client.serializers.DateTimeAdapter;

public class ListMemberResponse {

    public String id;
    @SerializedName("email_address")
    public String emailAddress;
    @SerializedName("unique_email_id")
    public String uniqueEmailId;
    @SerializedName("email_type")
    public String emailType;
    public ListMemberStatus status;
    @SerializedName("merge_fields")
    public Map<String, String> mergeFields;
    public Map<String, String> interests;
    public Map<String, BigDecimal> stats;
    @SerializedName("ip_signup")
    public String ipSignup;
    @SerializedName("timestamp_signup")
    @JsonAdapter(DateTimeAdapter.class)
    public Date timestampSignup;
    @SerializedName("ip_opt")
    public String ipOpt;
    @SerializedName("timestamp_opt")
    @JsonAdapter(DateTimeAdapter.class)
    public Date timestampOpt;
    @SerializedName("member_rating")
    public Integer memberRating;
    @SerializedName("last_changed")
    @JsonAdapter(DateTimeAdapter.class)
    public Date lastChanged;
    public String language;
    public Boolean vip;
    @SerializedName("email_client")
    public String emailClient;
    public ListMemberLocationResponse location;
    public ListMemberLastNoteResponse last_note;
    @SerializedName("list_id")
    public String listId;
    
}
