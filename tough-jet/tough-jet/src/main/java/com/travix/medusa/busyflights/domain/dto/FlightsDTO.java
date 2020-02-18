package com.travix.medusa.busyflights.domain.dto;

import java.util.ArrayList;
import java.util.List;

/**
 * List of flights to be returned
 */
public class FlightsDTO extends ResultBaseDTO {

    private List<ToughJetDTO> flights = new ArrayList<>();

    public List<ToughJetDTO> getFlights() {
        return flights;
    }

    public void setFlights(List<ToughJetDTO> flights) {
        this.flights = flights;
    }
}
