package com.travix.medusa.busyflights.domain.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
public class ToughJet implements Serializable, IFlight {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private Flight flight;
    private int numberOfAdults;
    private double basePrice;
    private double tax;
    private double discount;

    public Long getToughJetId() {
        return id;
    }

    public void setToughJetIdId(Long id) {
        this.id = id;
    }

    public Flight getFlight() {
        return flight;
    }

    public void setFlight(Flight flight) {
        this.flight = flight;
    }

    public int getNumberOfAdults() {
        return numberOfAdults;
    }

    public void setNumberOfAdults(int numberOfAdults) {
        this.numberOfAdults = numberOfAdults;
    }

    public double getBasePrice() {
        return basePrice;
    }

    public void setBasePrice(double fare) {
        this.basePrice = fare;
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

    @Override
    public Long getId() {
        return this.flight.getId();
    }

    @Override
    public void setId(Long id) {
        this.flight.setId(id);
    }

    @Override
    public String getAirline() {
        return this.flight.getAirline();
    }

    @Override
    public void setAirline(String airline) {
        this.flight.setAirline(airline);
    }

    @Override
    public String getOrigin() {
        return this.flight.getOrigin();
    }

    @Override
    public void setOrigin(String origin) {
        this.flight.setOrigin(origin);
    }

    @Override
    public String getDestination() {
        return this.flight.getDestination();
    }

    @Override
    public void setDestination(String destination) {
        this.flight.setDestination(destination);
    }

    @Override
    public Date getDepartureDate() {
        return this.flight.getDepartureDate();
    }

    @Override
    public void setDepartureDate(Date departureDate) {
        this.flight.setDepartureDate(departureDate);
    }

    @Override
    public Date getReturnDate() {
        return this.flight.getReturnDate();
    }

    @Override
    public void setReturnDate(Date returnDate) {
        this.flight.setReturnDate(returnDate);
    }
}
