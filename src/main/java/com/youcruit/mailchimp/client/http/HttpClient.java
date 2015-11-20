package com.youcruit.mailchimp.client.http;

import java.io.IOException;
import java.nio.charset.Charset;
import java.util.Map;

import com.youcruit.mailchimp.client.PomHelper;
import com.youcruit.mailchimp.client.objects.pojos.Operation;
import com.youcruit.mailchimp.client.objects.pojos.request.AbstractRequest;

public interface HttpClient {
    String VERSION = PomHelper.getVersion("com.youcruit", "mailchimp-v3-java-client");
    String USER_AGENT = "mailchimp-v3-java-client/" + VERSION;
    Charset UTF8 = Charset.forName("UTF-8");

    <V> V sync(Operation operation) throws IOException;
    
    <V> V sync(AbstractRequest requestBody, Method method, Class<V> responseClass, Map<String, String> queryParameters, String... pathSegments) throws IOException;

    public enum Method {
	PUT, POST, GET, DELETE
    }

}
