package com.travix.flight.Domain.entity;

import java.util.Date;

public interface IFlight {

    Long getId();
    void setId(final Long id);

    String getAirline();
    void setAirline(final String airline);

    String getOrigin();
    void setOrigin(final String origin);

    String getDestination();
    void setDestination(final String destination);

    Date getDepartureDate();
    void setDepartureDate(final Date departureDate);

    Date getReturnDate();
    void setReturnDate(final Date returnDate);


}
