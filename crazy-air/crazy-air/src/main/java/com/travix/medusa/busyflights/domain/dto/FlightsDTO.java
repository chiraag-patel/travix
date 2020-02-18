package com.travix.medusa.busyflights.domain.dto;

import java.util.ArrayList;
import java.util.List;
/**
 * List of flights to be returned
 */
public class FlightsDTO extends ResultBaseDTO {

    private List<CrazyAirDTO> flights = new ArrayList<>();

    public List<CrazyAirDTO> getFlights() {
        return flights;
    }

    public void setFlights(List<CrazyAirDTO> flights) {
        this.flights = flights;
    }
}
