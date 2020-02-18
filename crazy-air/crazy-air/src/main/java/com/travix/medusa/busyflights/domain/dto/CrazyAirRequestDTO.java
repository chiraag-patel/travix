package com.travix.medusa.busyflights.domain.dto;

import java.util.Date;
/**
 * DTO representing the request made to the crazy air api
 */
public class CrazyAirRequestDTO {

    private String origin;
    private String destination;
    private Date departureDate;
    private Date returnDate;
    private int passengerCount;

    public CrazyAirRequestDTO() {
    }

    public CrazyAirRequestDTO(String origin, String destination, Date departureDate, Date returnDate, int passengerCount) {
        this.origin = origin;
        this.destination = destination;
        this.departureDate = departureDate;
        this.returnDate = returnDate;
        this.passengerCount = passengerCount;
    }

    public String getOrigin() {
        return origin;
    }

    public void setOrigin(String origin) {
        this.origin = origin;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public Date getDepartureDate() {
        return departureDate;
    }

    public void setDepartureDate(Date departureDate) {
        this.departureDate = departureDate;
    }

    public Date getReturnDate() {
        return returnDate;
    }

    public void setReturnDate(Date returnDate) {
        this.returnDate = returnDate;
    }

    public int getPassengerCount() {
        return passengerCount;
    }

    public void setPassengerCount(int passengerCount) {
        this.passengerCount = passengerCount;
    }
}
