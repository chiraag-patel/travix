package com.travix.medusa.busyflights.domain.dto;


import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;

/**
 * DTO to represent the response to be sent from the endpoint
 */
public class ToughJetDTO {

    private String carrier;
    private double basePrice;
    private String departureAirportName;
    private String arrivalAirportName;
    private double tax;
    private double discount;

    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
    private Date outboundDateTime;

    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
    private Date inboundDateTime;

    public String getCarrier() {
        return carrier;
    }

    public void setCarrier(final String carrier) {
        this.carrier = carrier;
    }

    public double getBasePrice() {
        return basePrice;
    }

    public void setBasePrice(final double basePrice) {
        this.basePrice = basePrice;
    }

    public String getDepartureAirportName() {
        return departureAirportName;
    }

    public void setDepartureAirportName(final String departureAirportName) {
        this.departureAirportName = departureAirportName;
    }

    public String getArrivalAirportName() {
        return arrivalAirportName;
    }

    public void setArrivalAirportName(final String arrivalAirportName) {
        this.arrivalAirportName = arrivalAirportName;
    }

    public Date getOutboundDateTime() {
        return outboundDateTime;
    }

    public void setOutboundDateTime(Date outboundDateTime) {
        this.outboundDateTime = outboundDateTime;
    }

    public Date getInboundDateTime() {
        return inboundDateTime;
    }

    public void setInboundDateTime(Date inboundDateTime) {
        this.inboundDateTime = inboundDateTime;
    }

    public double getTax() {
        return tax;
    }

    public void setTax(double tax) {
        this.tax = tax;
    }

    public double getDiscount() {
        return discount;
    }

    public void setDiscount(double discount) {
        this.discount = discount;
    }
}
