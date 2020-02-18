package com.travix.medusa.busyflights.contorller;

import com.travix.medusa.busyflights.domain.dto.CrazyAirRequestDTO;
import com.travix.medusa.busyflights.domain.dto.FlightsDTO;
import com.travix.medusa.busyflights.service.AuthService;
import com.travix.medusa.busyflights.service.CrazyAirService;
import com.travix.medusa.busyflights.util.DateUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.text.ParseException;

@RestController
@RequestMapping(value = "/crazy-air")
public class CrazyAirController {

    @Autowired
    private CrazyAirService crazyAirService;

    @Autowired
    private AuthService authService;

    /**
     * Endpoint to get a list of flights that equal the request params
     * @param origin airport traveling from
     * @param destination airport traveling to
     * @param departureDate date leaving
     * @param returnDate date returning
     * @param passengerCount number of adults on flight
     * @param apiKey api key to ensure only authorized clients can access this endpoint
     * @return
     */
    @RequestMapping(value = "/get-flights", method = RequestMethod.GET)
    @ResponseBody
    public FlightsDTO getFlightsByValue(@RequestParam(value = "origin") final String origin,
                                            @RequestParam(value = "destination") final String destination,
                                            @RequestParam(value = "departureDate") final String departureDate,
                                            @RequestParam(value = "returnDate") final String returnDate,
                                            @RequestParam(value = "passengerCount") final int passengerCount,
                                            @RequestHeader("api-key") String apiKey){
        FlightsDTO result = new FlightsDTO();
        try {
            authService.isValidRequest(apiKey);
            CrazyAirRequestDTO request = new CrazyAirRequestDTO(origin, destination, DateUtil.formatDate(departureDate), DateUtil.formatDate(returnDate), passengerCount);
            result.setFlights(crazyAirService.getFlights(request));
            result.setResult("OK");
        } catch (ParseException e) {
            e.printStackTrace();
            result.setResult("ERROR");
            result.setMessage("Error retrieving flight results");
        } catch (Exception e) {
            result.setResult("ERROR");
            result.setMessage("Invalid request");
        }
        return result;
    }
}
