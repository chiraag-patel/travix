package com.travix.medusa.busyflights.domain.entity;

import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Date;

@Entity
public class CrazyAir implements Serializable, IFlight {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private Flight flight;

    @NotNull
    @Max(4)
    private int passengerCount;

    private double fare;
    private String cabinClass;

    public Long getCrazyAirId(){
        return this.id;
    }

    public void setCrazyAirId(Long id){
        this.id = id;
    }

    public Flight getFlight() {
        return flight;
    }

    public void setFlight(Flight flight) {
        this.flight = flight;
    }

    public int getPassengerCount() {
        return passengerCount;
    }

    public void setPassengerCount(int passengerCount) {
        this.passengerCount = passengerCount;
    }

    public double getFare() {
        return fare;
    }

    public void setFare(double fare) {
        this.fare = fare;
    }

    public String getCabinClass() {
        return cabinClass;
    }

    public void setCabinClass(String cabinClass) {
        this.cabinClass = cabinClass;
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
