package com.travix.medusa.busyflights.domain.dto.crazyAir;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;

public class CrazyAirResponseDTO {

    private String airline;
    private double price;
    private String cabinClass;
    private String departureAirportCode;
    private String destinationAirportCode;
    private String supplier = "Crazy Air";

    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
    private Date departureDate;

    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
    private Date arrivalDate;

    public String getAirline() {
        return airline;
    }

    public void setAirline(String airline) {
        this.airline = airline;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getCabinClass() {
        return cabinClass;
    }

    public void setCabinClass(String cabinClass) {
        this.cabinClass = cabinClass;
    }

    public String getDepartureAirportCode() {
        return departureAirportCode;
    }

    public void setDepartureAirportCode(String departureAirportCode) {
        this.departureAirportCode = departureAirportCode;
    }

    public String getDestinationAirportCode() {
        return destinationAirportCode;
    }

    public void setDestinationAirportCode(String destinationAirportCode) {
        this.destinationAirportCode = destinationAirportCode;
    }

    public Date getDepartureDate() {
        return departureDate;
    }

    public void setDepartureDate(Date departureDate) {
        this.departureDate = departureDate;
    }

    public Date getArrivalDate() {
        return arrivalDate;
    }

    public void setArrivalDate(Date arrivalDate) {
        this.arrivalDate = arrivalDate;
    }

    public String getSupplier() {
        return supplier;
    }

    public void setSupplier(String supplier) {
        this.supplier = supplier;
    }
}
