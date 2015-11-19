package com.youcruit.mailchimp.client;

import java.io.IOException;
import java.security.NoSuchAlgorithmException;
import java.util.Date;

import org.junit.Test;

import com.youcruit.mailchimp.client.objects.pojos.request.list.ListMemberRequest;
import com.youcruit.mailchimp.client.objects.pojos.request.list.ListMembersRequest;
import com.youcruit.mailchimp.client.objects.pojos.request.list.ListRequest;
import com.youcruit.mailchimp.client.objects.pojos.request.list.ListsRequest;


public class MailChimpINTTest extends HttpIT {
    
    @Test
    public void getLists() throws IOException {
	ListsRequest request = null;
	new ListClient(client).getLists(request);
    }
    
    @Test
    public void getListsQuery() throws IOException {
	ListsRequest request = new ListsRequest();
	request.beforeCampaignLastSent = new Date(100);
	request.beforeDateCreated = new Date(100);
	request.count = 1;
	new ListClient(client).getLists(request);
    }
    
    @Test
    public void getList() throws IOException {
	ListRequest request = null;
	new ListClient(client).getList("xxxxxx", request);
    }
    
    @Test
    public void getListMembers() throws IOException {
	ListMembersRequest request = null;
	new ListClient(client).getListMembers("xxxxx", request);
    }
    
    @Test
    public void getListMember() throws IOException, NoSuchAlgorithmException {
	String email = "xxx@example.com";
	ListMemberRequest request = null;
	new ListClient(client).getListMember("xxxxx", email, request);
    }
    
}
