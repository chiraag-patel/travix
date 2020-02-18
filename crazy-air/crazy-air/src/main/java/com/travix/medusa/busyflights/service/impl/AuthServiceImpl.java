package com.travix.medusa.busyflights.service.impl;

import com.travix.medusa.busyflights.config.ApiKeyConfig;
import com.travix.medusa.busyflights.service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AuthServiceImpl implements AuthService {

    @Autowired
    private ApiKeyConfig apiKeyConfig;

    /**
     * Method to check that api key matches the key on the properties file
     * if it does not match the key it throws an exception
     * @param apiKey key sent with the request
     * @throws Exception
     */
    @Override
    public void isValidRequest(final String apiKey) throws Exception {
        if(apiKey == null || apiKey.isEmpty() || !apiKey.equals(apiKeyConfig.getCrazyAirApi())){
            throw new Exception("Invalid Key");
        }
    }
}
