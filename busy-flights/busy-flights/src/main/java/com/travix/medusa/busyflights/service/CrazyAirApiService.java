package com.travix.medusa.busyflights.service;

import com.travix.medusa.busyflights.domain.dto.busyFlight.BusyFlightRequestDTO;
import com.travix.medusa.busyflights.domain.dto.crazyAir.CrazyAirFlightsDTO;

public interface CrazyAirApiService {


    CrazyAirFlightsDTO getCrazyAirFlights(final BusyFlightRequestDTO busyFlightRequestDTO);
}
