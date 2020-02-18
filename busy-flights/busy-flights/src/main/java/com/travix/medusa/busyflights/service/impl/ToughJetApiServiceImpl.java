package com.travix.medusa.busyflights.service.impl;

import com.travix.medusa.busyflights.config.ApiKeyConfig;
import com.travix.medusa.busyflights.domain.dto.busyFlight.BusyFlightRequestDTO;
import com.travix.medusa.busyflights.domain.dto.toughJet.ToughJetFlightsDTO;
import com.travix.medusa.busyflights.exception.BusyFlightException;
import com.travix.medusa.busyflights.service.ToughJetApiService;
import com.travix.medusa.busyflights.util.Constants;
import com.travix.medusa.busyflights.util.ParamValidation;
import com.travix.medusa.busyflights.util.UrlBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

@Service
public class ToughJetApiServiceImpl implements ToughJetApiService {

    @Autowired
    private UrlBuilder urlBuilder;

    @Autowired
    private ApiKeyConfig apiKeyConfig;

    /**
     * Method to make call to tough jet api inorder to get a list of flights
     * @param busyFlightRequestDTO request dto containing params required by api endpoint
     * @return ToughJetFlightsDTO with a list of flights
     */
    @Override
    public ToughJetFlightsDTO getToughJetFlights(BusyFlightRequestDTO busyFlightRequestDTO) {
        ParamValidation.checkForNull("Input params were null",busyFlightRequestDTO.getOrigin(), busyFlightRequestDTO.getDestination(),
                busyFlightRequestDTO.getDepartureDate(), busyFlightRequestDTO.getReturnDate(),
                busyFlightRequestDTO.getNumberOfPassengers());

        WebClient client = WebClient.builder().baseUrl(Constants.TOUGH_JET_URL).build();
        return client.get().uri(urlBuilder.buildUrl(busyFlightRequestDTO, Constants.TOUGH_JET_API_NAME))
                .header("api-key", apiKeyConfig.getToughJetApi())
                .retrieve().onStatus(HttpStatus::is4xxClientError, response ->
                        Mono.error(new BusyFlightException("Error contacting Tough Jet Api"))
                ).onStatus(HttpStatus::is5xxServerError, response ->
                        Mono.error(new BusyFlightException("Error contacting Tough Jet Api"))
                )
                .bodyToMono(ToughJetFlightsDTO.class).block();
    }
}
