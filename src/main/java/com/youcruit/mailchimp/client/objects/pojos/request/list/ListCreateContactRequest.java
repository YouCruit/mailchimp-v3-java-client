package com.youcruit.mailchimp.client.objects.pojos.request.list;

import com.youcruit.mailchimp.client.objects.pojos.request.AbstractRequest;

public class ListCreateContactRequest implements AbstractRequest {
    public String company;
    public String address1;
    public String address2;
    public String city;
    public String state;
    public String zip;
    public String country;
    public String phone;
}
