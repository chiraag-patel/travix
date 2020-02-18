package com.travix.medusa.busyflights.service;

import com.travix.medusa.busyflights.domain.dto.ToughJetDTO;
import com.travix.medusa.busyflights.domain.dto.ToughJetRequestDTO;

import java.util.List;

public interface ToughJetService {

    List<ToughJetDTO> getFlights(final ToughJetRequestDTO request);
}
