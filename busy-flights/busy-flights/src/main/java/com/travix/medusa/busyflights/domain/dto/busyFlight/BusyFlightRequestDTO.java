package com.travix.medusa.busyflights.domain.dto.busyFlight;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;

public class BusyFlightRequestDTO {

    private String origin;
    private String destination;
    private int numberOfPassengers;

    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
    private String departureDate;

    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
    private String returnDate;


    public BusyFlightRequestDTO() {
    }

    public BusyFlightRequestDTO(String origin, String destination, String departureDate, String returnDate, int numberOfPassengers) {
        this.origin = origin;
        this.destination = destination;
        this.departureDate = departureDate;
        this.returnDate = returnDate;
        this.numberOfPassengers = numberOfPassengers;
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

    public String getDepartureDate() {
        return departureDate;
    }

    public void setDepartureDate(String departureDate) {
        this.departureDate = departureDate;
    }

    public String getReturnDate() {
        return returnDate;
    }

    public void setReturnDate(String returnDate) {
        this.returnDate = returnDate;
    }

    public int getNumberOfPassengers() {
        return numberOfPassengers;
    }

    public void setNumberOfPassengers(int numberOfPassengers) {
        this.numberOfPassengers = numberOfPassengers;
    }
}
