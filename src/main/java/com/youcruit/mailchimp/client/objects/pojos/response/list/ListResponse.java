package com.youcruit.mailchimp.client.objects.pojos.response.list;

import java.util.Date;
import java.util.List;

import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import com.youcruit.mailchimp.client.serializers.RFC3339TypeAdapter;

public class ListResponse {
    
    public String id;
    public String name;
    public ListContactResponse contact;
    @SerializedName("permission_reminder")
    public String permissionReminder;
    @SerializedName("use_archive_bar")
    public Boolean useArchiveBar;
    @SerializedName("campaign_defaults")
    public ListCampaignDefaultsResponse campaignDefaults;
    @SerializedName("notify_on_subscribe")
    public String notifyOnSubscribe;
    @SerializedName("notify_on_unsubscribe")
    public String notifyOnUnsubscribe;
    @SerializedName("date_created")
    @JsonAdapter(RFC3339TypeAdapter.class)
    public Date dateCreated;
    @SerializedName("list_rating")
    public Integer listRating;
    @SerializedName("email_type_option")
    public Boolean emailTypeOption;
    @SerializedName("subscribe_url_short")
    public String subscribeUrlShort;
    @SerializedName("subscribe_url_long")
    public String subscribeUrlLong;
    @SerializedName("beamer_address")
    public String beamerAddress;
    public String visibility;
    public List<String> modules;
    public ListStatsResponse stats;
    @SerializedName("_links")
    public List<ListLinkResponse> links;
}
