package com.travix.medusa.busyflights.repository;

import com.travix.medusa.busyflights.domain.entity.CrazyAir;
import com.travix.medusa.busyflights.domain.entity.IFlight;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

public interface CrazyAirRepository extends CrudRepository<CrazyAir, Long> {

    /**
     * Query to query the db based on the given parameters for flights
     * @param origin flight start
     * @param destination flight end
     * @param departureDate date leaving
     * @param returnDate date returning
     * @param passengerCount number of adults
     * @return List<CrazyAir> List of Crazy Air entities from the db
     */
    @Query("from CrazyAir ca where ca.flight.origin = :origin and " +
            "ca.flight.destination = :destination and " +
            "ca.flight.departureDate = :departureDate and " +
            "ca.flight.returnDate = :returnDate and " +
            "ca.passengerCount = :passengerCount " +
            "order by ca.fare asc")
    List<IFlight> getFlightsByOriginDestinationDatesAndPassengers(@Param("origin")final String origin,
                                                                  @Param("destination") final String destination,
                                                                  @Param("departureDate") final Date departureDate,
                                                                  @Param("returnDate") final Date returnDate,
                                                                  @Param("passengerCount") final int passengerCount);

}
