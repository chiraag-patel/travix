package com.travix.medusa.busyflights.service.impl;

import com.travix.medusa.busyflights.config.ApiKeyConfig;
import com.travix.medusa.busyflights.domain.dto.busyFlight.BusyFlightRequestDTO;
import com.travix.medusa.busyflights.domain.dto.crazyAir.CrazyAirFlightsDTO;
import com.travix.medusa.busyflights.exception.BusyFlightException;
import com.travix.medusa.busyflights.service.CrazyAirApiService;
import com.travix.medusa.busyflights.util.Constants;
import com.travix.medusa.busyflights.util.ParamValidation;
import com.travix.medusa.busyflights.util.UrlBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

@Service
public class CrazyAirApiServiceImpl implements CrazyAirApiService {

    @Autowired
    private UrlBuilder urlBuilder;

    @Autowired
    private ApiKeyConfig apiKeyConfig;

    /**
     * Method to make call to crazy air api inorder to get a list of flights
     * @param busyFlightRequestDTO request dto containing params required by api endpoint
     * @return CrazyAirFlightsDTO with a list of flights
     */
    @Override
    public CrazyAirFlightsDTO getCrazyAirFlights(BusyFlightRequestDTO busyFlightRequestDTO) {
        ParamValidation.checkForNull("Input params were null",busyFlightRequestDTO.getOrigin(), busyFlightRequestDTO.getDestination(),
                busyFlightRequestDTO.getDepartureDate(), busyFlightRequestDTO.getReturnDate(),
                busyFlightRequestDTO.getNumberOfPassengers());

        WebClient client = WebClient.builder().baseUrl(Constants.CRAZY_AIR_URL).build();
        return client.get().uri(urlBuilder.buildUrl(busyFlightRequestDTO, Constants.CRAZY_AIR_API_NAME))
                .header("api-key", apiKeyConfig.getCrazyAirApi())
                .retrieve().onStatus(HttpStatus::is4xxClientError, response ->
                        Mono.error(new BusyFlightException("Error contacting Crazy Air Api"))
                ).onStatus(HttpStatus::is5xxServerError, response ->
                        Mono.error(new BusyFlightException("Error contacting Crazy Air Api"))
                )
                .bodyToMono(CrazyAirFlightsDTO.class).block();
    }
}
