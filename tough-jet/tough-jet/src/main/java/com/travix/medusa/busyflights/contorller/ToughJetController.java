package com.travix.medusa.busyflights.contorller;

import com.travix.medusa.busyflights.domain.dto.ToughJetRequestDTO;
import com.travix.medusa.busyflights.domain.dto.FlightsDTO;
import com.travix.medusa.busyflights.service.AuthService;
import com.travix.medusa.busyflights.service.ToughJetService;
import com.travix.medusa.busyflights.util.DateUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@RestController
@RequestMapping(value = "tough-jet")
public class ToughJetController {

    @Autowired
    private ToughJetService toughJetService;
    @Autowired
    private AuthService authService;

    /**
     * Endpoint to get a list of flights that equal the request params
     * @param from airport traveling from
     * @param to airport traveling to
     * @param outboundDate date leaving
     * @param inboundDate date returning
     * @param numberOfAdults number of adults on flight
     * @param apiKey api key to ensure only authorized clients can access this endpoint
     * @return
     */
    @RequestMapping(value = "/get-flights", method = RequestMethod.GET)
    @ResponseBody
    public FlightsDTO getTJFlightsByValue(@RequestParam(value = "from") final String from,
                                          @RequestParam(value = "to") final String to,
                                          @RequestParam(value = "outboundDate") final String outboundDate,
                                          @RequestParam(value = "inboundDate") final String inboundDate,
                                          @RequestParam(value = "numberOfAdults") final int numberOfAdults,
                                          @RequestHeader("api-key") final String apiKey) {
        FlightsDTO result = new FlightsDTO();
        try {
            authService.isValidRequest(apiKey);
            ToughJetRequestDTO request = new ToughJetRequestDTO(from, to, DateUtil.formatDate(outboundDate), DateUtil.formatDate(inboundDate), numberOfAdults);
            result.setFlights(toughJetService.getFlights(request));
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
