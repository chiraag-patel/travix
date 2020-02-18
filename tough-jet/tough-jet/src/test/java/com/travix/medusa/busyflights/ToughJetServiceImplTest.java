package com.travix.medusa.busyflights;

import com.travix.medusa.busyflights.domain.dto.ToughJetDTO;
import com.travix.medusa.busyflights.domain.dto.ToughJetRequestDTO;
import com.travix.medusa.busyflights.domain.entity.Flight;
import com.travix.medusa.busyflights.domain.entity.ToughJet;
import com.travix.medusa.busyflights.repository.ToughJetRepository;
import com.travix.medusa.busyflights.service.impl.ToughJetServiceImpl;
import com.travix.medusa.busyflights.util.DateUtil;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.doReturn;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ToughJetServiceImplTest {

    @Autowired
    ToughJetServiceImpl toughJetService;

    @Mock
    ToughJetRepository toughJetRepository;

    private static final double DELTA = 1e-15;

    @Test
    public void testGetFlights() throws ParseException {
        ToughJetRequestDTO request = new ToughJetRequestDTO();
        request.setFrom("LHR");
        request.setTo("AMS");
        request.setOutboundDate(DateUtil.formatDate("2020-02-10 00:00:00"));
        request.setInboundDate(DateUtil.formatDate("2020-02-19 00:00:00"));
        request.setNumberOfAdults(4);

        List<ToughJet> flights = new ArrayList<>();
        ToughJet toughJetFlight = new ToughJet();
        Flight flight = new Flight();
        toughJetFlight.setFlight(flight);
        toughJetFlight.setAirline("British Airways");
        toughJetFlight.setDepartureDate(DateUtil.formatDate("2020-02-10 00:00:00"));
        toughJetFlight.setReturnDate(DateUtil.formatDate("2020-02-19 00:00:00"));
        toughJetFlight.setBasePrice(855.00);
        toughJetFlight.setOrigin("LHR");
        toughJetFlight.setDestination("AMS");
        flights.add(toughJetFlight);

        doReturn(flights).when(toughJetRepository).getFlightsByOriginDestinationDatesAndPassengers(
                request.getFrom(),
                request.getTo(),
                request.getOutboundDate(),
                request.getInboundDate(),
                request.getNumberOfAdults());

        List<ToughJetDTO> result = toughJetService.getFlights(request);
        assertEquals("Error expected only 1 result",1,result.size());
        assertEquals("Error expected British Airways as carrier","British Airways",result.get(0).getCarrier());
        assertEquals("Error expected LHR as departure airport name","LHR",result.get(0).getDepartureAirportName());
        assertEquals("Error expected AMS as destination airport name","AMS",result.get(0).getArrivalAirportName());
        assertEquals("Error expected " + DateUtil.formatDate("2020-02-10 00:00:00") + " as outbound date",DateUtil.formatDate("2020-02-10 00:00:00"),result.get(0).getOutboundDateTime());
        assertEquals("Error expected " + DateUtil.formatDate("2020-02-19 00:00:00") + " as inbound date",DateUtil.formatDate("2020-02-19 00:00:00"),result.get(0).getInboundDateTime());
        assertEquals("Error expected 855.00 as base price after tax and discount",855D,result.get(0).getBasePrice(), DELTA);
    }
}
