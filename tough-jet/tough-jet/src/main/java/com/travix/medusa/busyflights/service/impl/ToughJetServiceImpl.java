package com.travix.medusa.busyflights.service.impl;

import com.travix.medusa.busyflights.domain.entity.IFlight;
import com.travix.medusa.busyflights.util.DozerMapper;
import com.travix.medusa.busyflights.util.NumberUtil;
import com.travix.medusa.busyflights.domain.dto.ToughJetRequestDTO;
import com.travix.medusa.busyflights.domain.entity.ToughJet;
import com.travix.medusa.busyflights.domain.dto.ToughJetDTO;
import com.travix.medusa.busyflights.repository.ToughJetRepository;
import com.travix.medusa.busyflights.service.ToughJetService;
import com.travix.medusa.busyflights.util.ParamValidation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ToughJetServiceImpl implements ToughJetService {

    @Autowired
    private ToughJetRepository toughJetRepository;

    @Autowired
    private DozerMapper mapper;

    /**
     * Mehtod to get flights that tough flights supplies based on the request received
     * @param request request sent to the endpoint with parameters to query the db with
     * @return List<ToughJetDTO> of flights found from the request
     */
    @Override
    public List<ToughJetDTO> getFlights(final ToughJetRequestDTO request) {
        ParamValidation.checkForNull("Input params were null",request.getFrom(), request.getTo(),
                request.getOutboundDate(), request.getInboundDate(),
                request.getNumberOfAdults());

        List<IFlight> flights = toughJetRepository.getFlightsByOriginDestinationDatesAndPassengers(request.getFrom(),
                request.getTo(), request.getOutboundDate(), request.getInboundDate(), request.getNumberOfAdults());
        List<ToughJetDTO> resultList = mapper.mapList(flights, ToughJetDTO.class);
        for (ToughJetDTO flight : resultList) {
            flight.setBasePrice(NumberUtil.calculateFinalAmount(flight.getBasePrice(), flight.getTax(), flight.getDiscount()));
        }
        return resultList;
    }
}
