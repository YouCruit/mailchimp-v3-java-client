package com.youcruit.mailchimp.client;

import java.io.IOException;
import java.util.Date;

import org.junit.Test;

import com.youcruit.mailchimp.client.objects.pojos.request.list.ListsRequest;
import com.youcruit.mailchimp.client.objects.pojos.response.list.ListsResponse;


public class MailChimpINTTest extends HttpIT {
    
    @Test
    public void getLists() throws IOException {
	ListsRequest request = null;
	ListsResponse lists = new ListClient(client).getLists(request);
    }
    
    @Test
    public void getListsQuery() throws IOException {
	ListsRequest request = new ListsRequest();
	request.beforeCampaignLastSent = new Date(100);
	request.beforeDateCreated = new Date(100);
	request.count = 1;
	ListsResponse lists = new ListClient(client).getLists(request);
    }
}
