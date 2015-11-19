package com.youcruit.mailchimp.client.objects.pojos.response.list;

import java.math.BigDecimal;

import com.google.gson.annotations.SerializedName;

public class ListMemberLocationResponse {

    public BigDecimal latitude;
    public BigDecimal longitude;
    public Integer gmtoff;
    public Integer dstoff;
    @SerializedName("country_code")
    public String countryCode;
    public String timezone;

}
