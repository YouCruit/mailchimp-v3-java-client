package com.youcruit.mailchimp.client.objects.pojos.response.list;

import java.util.List;

import com.google.gson.annotations.SerializedName;

public class ListMembersResponse {

    public List<ListMemberResponse> members;
    @SerializedName("list_id")
    public String listId;
    @SerializedName("total_items")
    public Integer totalItems;

}
