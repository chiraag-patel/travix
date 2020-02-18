package com.travix.medusa.busyflights.domain.dto.crazyAir;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CrazyAirFlightsDTO {

    private List<CrazyAirResponseDTO> flights = new ArrayList<>();

    public List<CrazyAirResponseDTO> getFlights() {
        return flights;
    }

    public void setFlights(List<CrazyAirResponseDTO> flights) {
        this.flights = flights;
    }
}
