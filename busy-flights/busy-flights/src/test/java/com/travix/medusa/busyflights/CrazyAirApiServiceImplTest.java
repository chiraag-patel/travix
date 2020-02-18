package com.travix.medusa.busyflights;

import com.jayway.jsonpath.DocumentContext;
import com.jayway.jsonpath.JsonPath;
import com.travix.medusa.busyflights.domain.dto.busyFlight.BusyFlightRequestDTO;
import com.travix.medusa.busyflights.domain.dto.crazyAir.CrazyAirFlightsDTO;
import com.travix.medusa.busyflights.domain.dto.crazyAir.CrazyAirResponseDTO;
import com.travix.medusa.busyflights.service.CrazyAirApiService;
import com.travix.medusa.busyflights.util.Constants;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;


@RunWith(SpringRunner.class)
@SpringBootTest
public class CrazyAirApiServiceImplTest {

    @Autowired
    CrazyAirApiService crazyAirApiService;

    private static CrazyAirFlightsDTO result;

    @Before
    public void setup(){
        result = new CrazyAirFlightsDTO();
        CrazyAirResponseDTO flight = new CrazyAirResponseDTO();
        flight.setAirline("British Airways");
        flight.setArrivalDate(new Date());
        flight.setDepartureDate(new Date());
        flight.setCabinClass("E");
        flight.setDepartureAirportCode("LHR");
        flight.setDestinationAirportCode("AMS");
        List<CrazyAirResponseDTO> resultList = new ArrayList<>();
        resultList.add(flight);
        result.setFlights(resultList);
    }

    @Test
    public void getCrazyAirFlights() throws InterruptedException {

    }

    private static WebClient getWebClientMock(final String resp) {
        WebClient mock = Mockito.mock(WebClient.class);
        WebClient.RequestHeadersUriSpec uriSpecMock = Mockito.mock(WebClient.RequestHeadersUriSpec.class);
        WebClient.RequestHeadersSpec headersSpecMock = Mockito.mock(WebClient.RequestHeadersSpec.class);
        WebClient.ResponseSpec responseSpecMock = Mockito.mock(WebClient.ResponseSpec.class);

        when(mock.get()).thenReturn(uriSpecMock);
        when(uriSpecMock.uri("")).thenReturn(headersSpecMock);
//        when(headersSpecMock.header(notNull(), notNull())).thenReturn(headersSpecMock);
//        when(headersSpecMock.headers(notNull())).thenReturn(headersSpecMock);
        when(headersSpecMock.retrieve()).thenReturn(responseSpecMock);
        when(responseSpecMock.bodyToMono(CrazyAirFlightsDTO.class).block())
                .thenReturn(result);

        return mock;
    }

}
