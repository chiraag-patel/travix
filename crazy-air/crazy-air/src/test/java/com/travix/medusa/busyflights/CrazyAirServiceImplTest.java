package com.travix.medusa.busyflights;

import com.travix.medusa.busyflights.domain.dto.CrazyAirDTO;
import com.travix.medusa.busyflights.domain.dto.CrazyAirRequestDTO;
import com.travix.medusa.busyflights.domain.entity.CrazyAir;
import com.travix.medusa.busyflights.domain.entity.Flight;
import com.travix.medusa.busyflights.repository.CrazyAirRepository;
import com.travix.medusa.busyflights.service.impl.CrazyAirServiceImpl;
import com.travix.medusa.busyflights.util.DateUtil;
import org.junit.Assert;
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
public class CrazyAirServiceImplTest {

    @Autowired
    CrazyAirServiceImpl crazyAirService;

    @Mock
    CrazyAirRepository crazyAirRepository;

    @Test
    public void testGetFlights() throws ParseException {
        CrazyAirRequestDTO request = new CrazyAirRequestDTO();
        request.setOrigin("LHR");
        request.setDestination("AMS");
        request.setDepartureDate(DateUtil.formatDate("2020-02-10 00:00:00"));
        request.setReturnDate(DateUtil.formatDate("2020-02-19 00:00:00"));
        request.setPassengerCount(4);

        List<CrazyAir> flights = new ArrayList<>();
        CrazyAir crazyAirFlight = new CrazyAir();
        Flight flight = new Flight();
        crazyAirFlight.setFlight(flight);
        crazyAirFlight.setAirline("British Airways");
        crazyAirFlight.setCabinClass("E");
        crazyAirFlight.setDepartureDate(DateUtil.formatDate("2020-02-10 00:00:00"));
        crazyAirFlight.setReturnDate(DateUtil.formatDate("2020-02-19 00:00:00"));
        crazyAirFlight.setFare(300.00);
        crazyAirFlight.setOrigin("LHR");
        crazyAirFlight.setDestination("AMS");
        flights.add(crazyAirFlight);

        doReturn(flights).when(crazyAirRepository).getFlightsByOriginDestinationDatesAndPassengers(
                request.getOrigin(),
                request.getDestination(),
                request.getDepartureDate(),
                request.getReturnDate(),
                request.getPassengerCount());

        List<CrazyAirDTO> result = crazyAirService.getFlights(request);
        assertEquals("Error expected only 1 result",1,result.size());
        assertEquals("Error expected British Airways as airline","British Airways",result.get(0).getAirline());
        assertEquals("Error expected E as cabin class","E",result.get(0).getCabinClass());
        assertEquals("Error expected LHR as departure airport code","LHR",result.get(0).getDepartureAirportCode());
        assertEquals("Error expected AMS as destination airport code","AMS",result.get(0).getDestinationAirportCode());
        assertEquals("Error expected " + DateUtil.formatDate("2020-02-10 00:00:00") + " as departure date",DateUtil.formatDate("2020-02-10 00:00:00"),result.get(0).getDepartureDate());
        assertEquals("Error expected " + DateUtil.formatDate("2020-02-19 00:00:00") + " as arrival date",DateUtil.formatDate("2020-02-19 00:00:00"),result.get(0).getArrivalDate());



    }

}
