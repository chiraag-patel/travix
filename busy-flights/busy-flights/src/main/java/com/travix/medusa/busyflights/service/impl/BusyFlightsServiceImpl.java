package com.travix.medusa.busyflights.service.impl;

import com.travix.medusa.busyflights.config.ApiKeyConfig;
import com.travix.medusa.busyflights.domain.dto.busyFlight.BusyFlightRequestDTO;
import com.travix.medusa.busyflights.domain.FlightsDTO;
import com.travix.medusa.busyflights.domain.dto.busyFlight.BusyFlightsResponseDTO;
import com.travix.medusa.busyflights.domain.dto.toughJet.ToughJetFlightsDTO;
import com.travix.medusa.busyflights.domain.dto.crazyAir.CrazyAirFlightsDTO;
import com.travix.medusa.busyflights.service.BusyFlightsService;
import com.travix.medusa.busyflights.service.CrazyAirApiService;
import com.travix.medusa.busyflights.service.ToughJetApiService;
import com.travix.medusa.busyflights.util.Constants;
import com.travix.medusa.busyflights.util.DozerMapper;
import com.travix.medusa.busyflights.util.ParamValidation;
import com.travix.medusa.busyflights.util.UrlBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

import java.util.Collection;
import java.util.Collections;
import java.util.List;

@Service
public class BusyFlightsServiceImpl implements BusyFlightsService {

    @Autowired
    private DozerMapper mapper;

    @Autowired
    private CrazyAirApiService crazyAirApiService;

    @Autowired
    private ToughJetApiService toughJetApiService;

    /**
     * Method to make calls to Crazy air and tough jet API's to get list of flights
     * @param busyFlightRequestDTO request dto containing params to be searched against
     * @return FlightsDTO containing a merged list of flights from Crazy air and Tough Jet
     */
    @Override
    public FlightsDTO getFlightInformation(final BusyFlightRequestDTO busyFlightRequestDTO) {
        ParamValidation.checkForNull("Input params were null",busyFlightRequestDTO.getOrigin(), busyFlightRequestDTO.getDestination(),
                busyFlightRequestDTO.getDepartureDate(), busyFlightRequestDTO.getReturnDate(),
                busyFlightRequestDTO.getNumberOfPassengers());

        CrazyAirFlightsDTO crazyAirFlights = crazyAirApiService.getCrazyAirFlights(busyFlightRequestDTO);
        ToughJetFlightsDTO toughJetFlights = toughJetApiService.getToughJetFlights(busyFlightRequestDTO);


        FlightsDTO flightsDTO = new FlightsDTO();

        flightsDTO.setFlights((List<BusyFlightsResponseDTO>) mapper.mapList(crazyAirFlights.getFlights(), BusyFlightsResponseDTO.class));
        flightsDTO.getFlights().addAll((Collection<? extends BusyFlightsResponseDTO>) mapper.mapList(toughJetFlights.getFlights(),BusyFlightsResponseDTO.class));

        return flightsDTO;
    }
}
