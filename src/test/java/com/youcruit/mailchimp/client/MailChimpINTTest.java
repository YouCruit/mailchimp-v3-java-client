package com.youcruit.mailchimp.client;

import java.io.IOException;
import java.util.Date;

import org.junit.Test;

import com.youcruit.mailchimp.client.objects.pojos.batch.operation.BatchOperation;
import com.youcruit.mailchimp.client.objects.pojos.list.ListMemberStatus;
import com.youcruit.mailchimp.client.objects.pojos.operation.list.CreateListMemberOperation;
import com.youcruit.mailchimp.client.objects.pojos.operation.list.CreateListOperation;
import com.youcruit.mailchimp.client.objects.pojos.operation.list.DeleteListMemberOperation;
import com.youcruit.mailchimp.client.objects.pojos.operation.list.GetListMemberOperation;
import com.youcruit.mailchimp.client.objects.pojos.operation.list.GetListMembersOperation;
import com.youcruit.mailchimp.client.objects.pojos.operation.list.GetListOperation;
import com.youcruit.mailchimp.client.objects.pojos.operation.list.GetListsOperation;
import com.youcruit.mailchimp.client.objects.pojos.request.batch.BatchRequest.BatchRequestBuilder;
import com.youcruit.mailchimp.client.objects.pojos.request.list.CreateListRequest;
import com.youcruit.mailchimp.client.objects.pojos.request.list.ListCreateCampaignDefaultsRequest;
import com.youcruit.mailchimp.client.objects.pojos.request.list.ListCreateContactRequest;
import com.youcruit.mailchimp.client.objects.pojos.request.list.ListCreateMemberRequest;
import com.youcruit.mailchimp.client.objects.pojos.request.list.ListsRequest;

public class MailChimpINTTest extends HttpIT {
    @Test
    public void testBatch() throws IOException {
	BatchRequestBuilder batchRequestBuilder = new BatchRequestBuilder();
	batchRequestBuilder.operation(new GetListOperation("xxxxxxxxxx")).operation(new GetListMembersOperation("xxxxxxxxxx"));
	BatchOperation operation = new BatchOperation(batchRequestBuilder.create());
	new BatchClient(client).batch(operation);
    }

    @Test
    public void getLists() throws IOException {
	GetListsOperation operation = new GetListsOperation();
	new ListClient(client).getLists(operation);
    }

    @Test
    public void getList() throws IOException {
	GetListOperation operation = new GetListOperation("xxxxxxxxxx");
	new ListClient(client).getList(operation);
    }

    @Test
    public void createList() throws IOException {
	CreateListRequest request = new CreateListRequest();
	request.name = "Test Operation";
	ListCreateContactRequest contactRequest = new ListCreateContactRequest();
	contactRequest.company = "TestCompany";
	contactRequest.address1 = "That road 9";
	contactRequest.city = "That town";
	contactRequest.zip = "12345";
	contactRequest.country = "SE";
	contactRequest.state = "";
	request.contact = contactRequest;
	request.permissionReminder = "You are getting this email because you subscribed to Test";
	ListCreateCampaignDefaultsRequest campaignRequest = new ListCreateCampaignDefaultsRequest();
	campaignRequest.subject = "Heyoo";
	campaignRequest.fromName = "TestCompany";
	campaignRequest.fromEmail = "foo@example.com";
	campaignRequest.language = "en";
	request.campaignDefaults = campaignRequest;
	request.emailTypeOption = false;
	CreateListOperation operation = new CreateListOperation(request);
	new ListClient(client).createList(operation);
    }

    @Test
    public void getListsQuery() throws IOException {
	ListsRequest request = new ListsRequest();
	request.beforeDateCreated = new Date(100);
	GetListsOperation operation = new GetListsOperation(request);
	new ListClient(client).getLists(operation);
    }

    @Test
    public void getListMembers() throws IOException {
	GetListMembersOperation operation = new GetListMembersOperation("xxxxxxxxxx");
	new ListClient(client).getListMembers(operation);
    }

    @Test
    public void createListMember() throws IOException {
	ListCreateMemberRequest request = new ListCreateMemberRequest();
	request.emailAddress = "foo@example.com";
	request.status = ListMemberStatus.SUBSCRIBED;
	CreateListMemberOperation operation = new CreateListMemberOperation("xxxxxxxxxx", request);
	new ListClient(client).createListMember(operation);
    }

    @Test
    public void getListMember() throws IOException {
	GetListMemberOperation operation = new GetListMemberOperation("xxxxxxxxxx", "foo@example.com");
	new ListClient(client).getListMember(operation);
    }

    @Test
    public void deleteListMember() throws IOException {
	DeleteListMemberOperation operation = new DeleteListMemberOperation("xxxxxxxxxx", "foo@example.com");
	new ListClient(client).deleteListMember(operation);
    }
}
