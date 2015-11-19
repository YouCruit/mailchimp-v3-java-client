package com.youcruit.mailchimp.client.objects.pojos.response.list;

import java.util.List;

import com.google.gson.annotations.SerializedName;

public class ListsResponse {
    public List<ListResponse> lists;
    @SerializedName("total_items")
    public Integer totalItems;
}
