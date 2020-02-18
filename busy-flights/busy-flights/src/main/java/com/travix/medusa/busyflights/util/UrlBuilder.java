package com.travix.medusa.busyflights.util;

import com.travix.medusa.busyflights.domain.dto.busyFlight.BusyFlightRequestDTO;
import org.springframework.stereotype.Service;

import javax.validation.constraints.NotNull;

@Service
public class UrlBuilder {

    /**
     * Method to build a url required to access the api endpoint
     * @param busyFlightRequestDTO contains params used when building the url
     * @param api name of the api url is being built for
     * @return String of the url with params
     */
    public String buildUrl(@NotNull final BusyFlightRequestDTO busyFlightRequestDTO,@NotNull final String api){
        String url = "";
        if(busyFlightRequestDTO != null && api != null){
            switch (api){
                case Constants.CRAZY_AIR_API_NAME:
                    url = getURLForCrazyAir(busyFlightRequestDTO);
                    break;
                case Constants.TOUGH_JET_API_NAME:
                    url = getURLForToughJet(busyFlightRequestDTO);
                    break;
            }
        }
        return url;
    }

    /**
     * Builds url for crazy air api with params
     * @param busyFlightRequestDTO contains params used for building up url
     * @return String of the url
     */
    private String getURLForCrazyAir(@NotNull final BusyFlightRequestDTO busyFlightRequestDTO){
        String  url = Constants.GET_FLIGHTS_ENDPOINT;
        url = String.format("%s?origin=%s&destination=%s&departureDate=%s&returnDate=%s&passengerCount=%s",
                url,
                busyFlightRequestDTO.getOrigin(),
                busyFlightRequestDTO.getDestination(),
                busyFlightRequestDTO.getDepartureDate(),
                busyFlightRequestDTO.getReturnDate(),
                busyFlightRequestDTO.getNumberOfPassengers());
        return url;
    }
    /**
     * Builds url for tough jet api with params
     * @param busyFlightRequestDTO contains params used for building up url
     * @return String of the url
     */
    private String getURLForToughJet(@NotNull final BusyFlightRequestDTO busyFlightRequestDTO){
        String  url = Constants.GET_FLIGHTS_ENDPOINT;
        url = String.format("%s?from=%s&to=%s&outboundDate=%s&inboundDate=%s&numberOfAdults=%s",
                url,
                busyFlightRequestDTO.getOrigin(),
                busyFlightRequestDTO.getDestination(),
                busyFlightRequestDTO.getDepartureDate(),
                busyFlightRequestDTO.getReturnDate(),
                busyFlightRequestDTO.getNumberOfPassengers());
        return url;
    }

}
