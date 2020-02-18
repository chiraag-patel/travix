package com.travix.medusa.busyflights.config;

import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties("key")
public class ApiKeyConfig {

    private String crazyAirApi;

    public String getCrazyAirApi() {
        return crazyAirApi;
    }

    public void setCrazyAirApi(String crazyAirApi) {
        this.crazyAirApi = crazyAirApi;
    }
}
