package com.travix.medusa.busyflights.service;

import javax.validation.constraints.NotNull;

public interface AuthService {

    void isValidRequest(final String apiKey) throws Exception;

}
