package com.travix.medusa.busyflights.service;

import com.travix.medusa.busyflights.domain.dto.busyFlight.BusyFlightRequestDTO;
import com.travix.medusa.busyflights.domain.FlightsDTO;
import reactor.core.publisher.Mono;

public interface BusyFlightsService {

    FlightsDTO getFlightInformation(final BusyFlightRequestDTO busyFlightRequestDTO);
}
