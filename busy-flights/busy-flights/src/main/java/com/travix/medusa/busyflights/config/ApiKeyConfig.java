package com.travix.medusa.busyflights.config;

import org.springframework.boot.context.properties.ConfigurationProperties;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@ConfigurationProperties("key")
public class ApiKeyConfig {

    @NotNull
    @NotBlank
    private String crazyAirApi;

    @NotNull
    @NotBlank
    private String toughJetApi;

    public String getCrazyAirApi() {
        return crazyAirApi;
    }

    public void setCrazyAirApi(String crazyAirApi) {
        this.crazyAirApi = crazyAirApi;
    }

    public String getToughJetApi() {
        return toughJetApi;
    }

    public void setToughJetApi(String toughJetApi) {
        this.toughJetApi = toughJetApi;
    }
}
