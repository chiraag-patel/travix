package com.travix.medusa.busyflights.service;

import com.travix.medusa.busyflights.domain.dto.CrazyAirDTO;
import com.travix.medusa.busyflights.domain.dto.CrazyAirRequestDTO;

import java.util.List;

public interface CrazyAirService {

    List<CrazyAirDTO> getFlights(final CrazyAirRequestDTO request);
}
