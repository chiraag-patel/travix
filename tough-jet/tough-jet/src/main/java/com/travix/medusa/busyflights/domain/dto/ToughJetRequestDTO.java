package com.travix.medusa.busyflights.domain.dto;

import java.util.Date;

/**
 * DTO representing the request made to the tough jet api
 */
public class ToughJetRequestDTO {

    private String from;
    private String to;
    private Date outboundDate;
    private Date inboundDate;
    private int numberOfAdults;

    public ToughJetRequestDTO() {
    }

    public ToughJetRequestDTO(String from, String to, Date outboundDate, Date inboundDate, int numberOfAdults) {
        this.from = from;
        this.to = to;
        this.outboundDate = outboundDate;
        this.inboundDate = inboundDate;
        this.numberOfAdults = numberOfAdults;
    }

    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public String getTo() {
        return to;
    }

    public void setTo(String to) {
        this.to = to;
    }

    public Date getOutboundDate() {
        return outboundDate;
    }

    public void setOutboundDate(Date outboundDate) {
        this.outboundDate = outboundDate;
    }

    public Date getInboundDate() {
        return inboundDate;
    }

    public void setInboundDate(Date inboundDate) {
        this.inboundDate = inboundDate;
    }

    public int getNumberOfAdults() {
        return numberOfAdults;
    }

    public void setNumberOfAdults(int numberOfAdults) {
        this.numberOfAdults = numberOfAdults;
    }
}
