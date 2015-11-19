package com.youcruit.mailchimp.client.objects.pojos.request.list;

import java.math.BigDecimal;

public class ListMemberCreateLocationRequest {
    
    public BigDecimal latitude;
    public BigDecimal longitude;
    
    public ListMemberCreateLocationRequest() {}
    
    public ListMemberCreateLocationRequest(BigDecimal latitude, BigDecimal longitude) {
	this.latitude = latitude;
	this.longitude = longitude;
    }

}
