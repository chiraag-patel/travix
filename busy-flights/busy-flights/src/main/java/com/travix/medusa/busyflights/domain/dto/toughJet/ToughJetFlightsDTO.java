package com.travix.medusa.busyflights.domain.dto.toughJet;

import java.util.ArrayList;
import java.util.List;

public class ToughJetFlightsDTO {

    List<ToughJetResponseDTO> flights = new ArrayList<>();

    public List<ToughJetResponseDTO> getFlights() {
        return flights;
    }

    public void setFlights(List<ToughJetResponseDTO> flights) {
        this.flights = flights;
    }
}
