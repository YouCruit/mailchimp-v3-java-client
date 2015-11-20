package com.youcruit.mailchimp.client.objects.pojos.request.list;

import com.google.gson.annotations.SerializedName;

public class CreateListRequest {
    public String name;
    public ListCreateContactRequest contact;
    @SerializedName("permission_reminder")
    public String permissionReminder;
    @SerializedName("use_archive_bar")
    public Boolean useArchiveBar;
    @SerializedName("campaign_defaults")
    public ListCreateCampaignDefaultsRequest campaignDefaults;
    @SerializedName("notify_on_subscribe")
    public String notifyOnSubscribe;
    @SerializedName("notify_on_unsubscribe")
    public String notifyOnUnsubscribe;
    @SerializedName("email_type_option")
    public Boolean emailTypeOption;
    public String visibility;
}
