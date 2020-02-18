package com.travix.medusa.busyflights.domain.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
public class Flight implements IFlight, Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String airline;
    private String origin;
    private String destination;
    private Date departureDate;
    private Date returnDate;


    @Override
    public Long getId() {
        return this.id;
    }

    @Override
    public void setId(final Long id) {
        this.id = id;
    }

    @Override
    public String getAirline() {
        return this.airline;
    }

    @Override
    public void setAirline(final String airline) {
        this.airline = airline;
    }

    @Override
    public String getOrigin() {
        return this.origin;
    }

    @Override
    public void setOrigin(final String origin) {
        this.origin = origin;
    }

    @Override
    public String getDestination() {
        return this.destination;
    }

    @Override
    public void setDestination(final String destination) {
        this.destination = destination;
    }

    @Override
    public Date getDepartureDate() {
        return this.departureDate;
    }

    @Override
    public void setDepartureDate(final Date departureDate) {
        this.departureDate = departureDate;
    }

    @Override
    public Date getReturnDate() {
        return this.returnDate;
    }

    @Override
    public void setReturnDate(final Date returnDate) {
        this.returnDate = returnDate;
    }
}
