package com.travix.medusa.busyflights;

import com.travix.medusa.busyflights.domain.dto.busyFlight.BusyFlightRequestDTO;
import com.travix.medusa.busyflights.util.Constants;
import com.travix.medusa.busyflights.util.UrlBuilder;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UrlBuilderTest {

    @Autowired
    UrlBuilder urlBuilder;

    String crazyAirExpected = "get-flights?origin=LHR&destination=AMS&departureDate=2020-02-10 00:00:00&returnDate=2020-02-19 00:00:00&passengerCount=4";
    String toughJetExpected = "get-flights?from=LHR&to=AMS&outboundDate=2020-02-10 00:00:00&inboundDate=2020-02-19 00:00:00&numberOfAdults=4";

    private BusyFlightRequestDTO flightRequestDTO;

    @Before
    public void setUp(){
        flightRequestDTO = new BusyFlightRequestDTO();
        flightRequestDTO.setOrigin("LHR");
        flightRequestDTO.setDestination("AMS");
        flightRequestDTO.setDepartureDate("2020-02-10 00:00:00");
        flightRequestDTO.setReturnDate("2020-02-19 00:00:00");
        flightRequestDTO.setNumberOfPassengers(4);
    }

    @Test
    public void testUrlBuilderForCrazyAir(){
        Assert.assertEquals("Error incorrect url returned",crazyAirExpected, urlBuilder.buildUrl(flightRequestDTO, Constants.CRAZY_AIR_API_NAME));
    }

    @Test
    public void testUrlBuilderForToughJet(){
        Assert.assertEquals("Error incorrect url returned",toughJetExpected, urlBuilder.buildUrl(flightRequestDTO, Constants.TOUGH_JET_API_NAME));
    }

}
