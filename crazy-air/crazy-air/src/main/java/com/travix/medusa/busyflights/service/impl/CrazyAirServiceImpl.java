package com.travix.medusa.busyflights.service.impl;

import com.google.gson.Gson;
import com.travix.medusa.busyflights.domain.entity.IFlight;
import com.travix.medusa.busyflights.util.DozerMapper;
import com.travix.medusa.busyflights.domain.dto.CrazyAirRequestDTO;
import com.travix.medusa.busyflights.domain.dto.CrazyAirDTO;
import com.travix.medusa.busyflights.repository.CrazyAirRepository;
import com.travix.medusa.busyflights.service.CrazyAirService;

import com.travix.medusa.busyflights.util.ParamValidation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.validation.constraints.NotNull;
import java.util.List;

@Service
public class CrazyAirServiceImpl implements CrazyAirService {

    @Autowired
    private CrazyAirRepository crazyAirRepository;

    @Autowired
    private DozerMapper mapper;

    /**
     * Mehtod to get flights that crazy air supplies based on the request received
     * @param request request sent to the endpoint with parameters to query the db with
     * @return List<CrazyAirDTO> of flights found from the request
     */
    @Override
    public List<CrazyAirDTO> getFlights(@NotNull final CrazyAirRequestDTO request) {
        ParamValidation.checkForNull("Input params were null",request.getOrigin(), request.getDestination(),
                request.getDepartureDate(), request.getReturnDate(),
                request.getPassengerCount());

        List<IFlight> flights = crazyAirRepository.getFlightsByOriginDestinationDatesAndPassengers(request.getOrigin(),
                request.getDestination(), request.getDepartureDate(), request.getReturnDate(), request.getPassengerCount());

        return mapper.mapList(flights,CrazyAirDTO.class);
    }
}
