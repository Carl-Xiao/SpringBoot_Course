package com.xiao;

import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(prefix = "redission")
public class RedisConfigProperties {
    private String url;
    private String passwprd;
    private String database;

    public String getPasswprd() {
        return passwprd;
    }

    public void setPasswprd(String passwprd) {
        this.passwprd = passwprd;
    }

    public String getDatabase() {
        return database;
    }

    public void setDatabase(String database) {
        this.database = database;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
