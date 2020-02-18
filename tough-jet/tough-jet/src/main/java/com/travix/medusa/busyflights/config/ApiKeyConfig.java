package com.travix.medusa.busyflights.config;

import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties("api")
public class ApiKeyConfig {
    private String toughJetApi;

    public String getToughJetApi() {
        return toughJetApi;
    }

    public void setToughJetApi(String toughJetApi) {
        this.toughJetApi = toughJetApi;
    }
}
