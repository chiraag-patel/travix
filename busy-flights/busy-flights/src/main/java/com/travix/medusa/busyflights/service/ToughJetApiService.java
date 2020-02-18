package com.travix.medusa.busyflights.service;

import com.travix.medusa.busyflights.domain.dto.busyFlight.BusyFlightRequestDTO;
import com.travix.medusa.busyflights.domain.dto.toughJet.ToughJetFlightsDTO;

public interface ToughJetApiService {

    ToughJetFlightsDTO getToughJetFlights(final BusyFlightRequestDTO busyFlightRequestDTO);

}
