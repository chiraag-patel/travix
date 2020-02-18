package com.travix.medusa.busyflights.controller;

import com.travix.medusa.busyflights.domain.dto.busyFlight.BusyFlightRequestDTO;
import com.travix.medusa.busyflights.domain.FlightsDTO;
import com.travix.medusa.busyflights.service.BusyFlightsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/busy-flights")
public class BusyFlightsController {

    @Autowired
    private BusyFlightsService busyFlightsService;

    /**
     * Endpoint to get flights from the given params, sends a http request ot crazy air api and tough jet api and
     * return a list of flights from both
     * @param origin airport traveling from
     * @param destination airport traveling to
     * @param departureDate date leaving
     * @param returnDate date returning
     * @param numberOfPassengers number of passengers on flight
     * @return FlightDTO with a list of flights from both crazy air api and tough jet api
     */
    @RequestMapping(value = "get-flights", method = RequestMethod.GET)
    @ResponseBody
    public FlightsDTO getFlights(@RequestParam(value = "origin") final String origin,
                                 @RequestParam(value = "destination") final String destination,
                                 @RequestParam(value = "departureDate") final String departureDate,
                                 @RequestParam(value = "returnDate") final String returnDate,
                                 @RequestParam(value = "numberOfPassengers") final int numberOfPassengers) {

        BusyFlightRequestDTO busyFlightRequestDTO = new BusyFlightRequestDTO(origin, destination, departureDate, returnDate, numberOfPassengers);
        FlightsDTO result = busyFlightsService.getFlightInformation(busyFlightRequestDTO);

        return result;
    }


}
