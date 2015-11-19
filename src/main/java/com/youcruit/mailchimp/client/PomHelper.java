package com.youcruit.mailchimp.client;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class PomHelper {
    public static Properties getProperties(String groupId, String artifactId) {
        try (InputStream is = PomHelper.class.getClassLoader().getResourceAsStream("META-INF/maven/"+groupId+"/"+artifactId+"/pom.properties")) {
            if (is != null) {
                Properties props = new Properties();
                props.load(is);
                return props;
            }
        } catch (IOException e) {
        }
        return null;
    }

    public static String getProperty(String groupId, String artifactId, String propertyName) {
        Properties properties = getProperties(groupId, artifactId);
        if (properties != null) {
            return (String) properties.get(propertyName);
        }
        return null;
    }

    public static String getVersion(String groupId, String artifactId) {
        String version = getProperty(groupId, artifactId, "version");
        if (version != null) {
            return version;
        }
        return "UNKNOWN";
    }
}
