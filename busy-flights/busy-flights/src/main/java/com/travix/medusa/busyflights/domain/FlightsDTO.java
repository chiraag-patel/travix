package com.travix.medusa.busyflights.domain;

import com.travix.medusa.busyflights.domain.dto.busyFlight.BusyFlightRequestDTO;
import com.travix.medusa.busyflights.domain.dto.busyFlight.BusyFlightsResponseDTO;
import com.travix.medusa.busyflights.domain.dto.crazyAir.CrazyAirFlightsDTO;
import com.travix.medusa.busyflights.domain.dto.toughJet.ToughJetFlightsDTO;

import java.util.ArrayList;
import java.util.List;

public class FlightsDTO {

    public FlightsDTO() {
    }

    public FlightsDTO(List<BusyFlightsResponseDTO> flights) {
        this.flights = flights;
    }

    List<BusyFlightsResponseDTO> flights = new ArrayList<>();

    public FlightsDTO(CrazyAirFlightsDTO crazyAirFlightsDTO, ToughJetFlightsDTO toughJetFlightsDTO) {

    }

    public List<BusyFlightsResponseDTO> getFlights() {
        return flights;
    }

    public void setFlights(List<BusyFlightsResponseDTO> flights) {
        this.flights = flights;
    }
}
