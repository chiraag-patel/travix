package com.travix.medusa.busyflights.repository;

import com.travix.medusa.busyflights.domain.entity.IFlight;
import com.travix.medusa.busyflights.domain.entity.ToughJet;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.Date;
import java.util.List;

public interface ToughJetRepository extends CrudRepository<ToughJet, Long> {

    /**
     * Query to query the db based on the given parameters for flights
     * @param origin flight start
     * @param destination flight end
     * @param outboundDate date leaving
     * @param inboundDate date returning
     * @param numberOfAdults number of adults
     * @return List<ToughJet> List of Tough Jet entities from the db
     */
    @Query("from ToughJet tj where tj.flight.origin = :origin and " +
            "tj.flight.destination = :destination and " +
            "tj.flight.departureDate = :outboundDate and " +
            "tj.flight.returnDate = :inboundDate and " +
            "tj.numberOfAdults = :numberOfAdults" +
            " order by tj.basePrice asc")
    List<IFlight> getFlightsByOriginDestinationDatesAndPassengers(@Param("origin")final String origin,
                                                                  @Param("destination") final String destination,
                                                                  @Param("outboundDate") final Date outboundDate,
                                                                  @Param("inboundDate") final Date inboundDate,
                                                                  @Param("numberOfAdults") final int numberOfAdults);

}
