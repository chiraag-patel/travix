package com.travix.medusa.busyflights;

import com.travix.medusa.busyflights.controller.BusyFlightsController;
import com.travix.medusa.busyflights.domain.FlightsDTO;
import com.travix.medusa.busyflights.domain.dto.busyFlight.BusyFlightRequestDTO;
import com.travix.medusa.busyflights.domain.dto.busyFlight.BusyFlightsResponseDTO;
import com.travix.medusa.busyflights.service.BusyFlightsService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.verification.VerificationMode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MockMvcBuilder;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.text.SimpleDateFormat;
import java.util.Date;

import static java.util.EnumSet.allOf;

import static org.assertj.core.internal.bytebuddy.matcher.ElementMatchers.is;
import static org.hamcrest.CoreMatchers.hasItem;
import static org.hamcrest.Matchers.hasProperty;
import static org.hamcrest.Matchers.hasSize;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyNoMoreInteractions;
import static org.springframework.test.web.client.ExpectedCount.times;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;

@RunWith(SpringRunner.class)
@SpringBootTest
public class BusyFlightControllerTest {

    private MockMvc mockMvc;
    String crazyAirExpected = "get-flights?origin=LHR&destination=AMS&departureDate=2020-02-10 00:00:00&returnDate=2020-02-19 00:00:00&passengerCount=4";

    @Autowired
    private BusyFlightsService busyFlightsService;

    @Autowired
    private BusyFlightsController busyFlightsController;

    @Test
    public void testBusyFlightController() throws Exception {
//
//        Date date1 = new SimpleDateFormat("yyyy-MM-dd").parse("2020-02-19 00:00:00");
//        Date date2 = new SimpleDateFormat("yyyy-MM-dd").parse("2020-02-10 00:00:00");
//
//        FlightsDTO result = new FlightsDTO();
//        BusyFlightsResponseDTO flight = new BusyFlightsResponseDTO();
//        flight.setArrivalDate(date1);
//        flight.setDepartureDate(date2);
//        flight.setDepartureAirportCode("LHR");
//        flight.setDepartureAirportCode("AMS");
//        flight.setAirline("British Airways");
//
//        String uri = "/busy-flights/get-flights";
//
//        RequestBuilder builder = MockMvcRequestBuilders
//                .get(uri).accept(MediaType.APPLICATION_JSON)
//                .contentType(MediaType.APPLICATION_JSON);
//
//        MvcResult mvcResult = mockMvc.perform(builder).andReturn();
//        MockHttpServletResponse response = mvcResult.getResponse();
    }

}
