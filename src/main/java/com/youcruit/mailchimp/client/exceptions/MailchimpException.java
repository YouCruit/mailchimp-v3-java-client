package com.youcruit.mailchimp.client.exceptions;

import java.net.URI;

public class MailchimpException extends RuntimeException {
    private static final long serialVersionUID = -4918650485539785416L;
    private int responseCode = -1;
    private URI uri;

    public MailchimpException(String message) {
        super(message);
    }

    public MailchimpException(String message, Throwable t) {
        super(message, t);
    }

    public MailchimpException(int responseCode, String message, URI uri) {
        super(message);
        this.responseCode = responseCode;
        this.uri = uri;
    }

    public MailchimpException(int responseCode, String message, URI uri, Throwable t) {
        super(message, t);
        this.responseCode = responseCode;
        this.uri = uri;
    }

    public MailchimpException() {

    }

    public int getResponseCode() {
        return responseCode;
    }


    public URI getUri() {
        return uri;
    }

    @Override
    public void printStackTrace() {
        System.err.println("ResponseCode : " + this.responseCode);
        super.printStackTrace();
    }
}
