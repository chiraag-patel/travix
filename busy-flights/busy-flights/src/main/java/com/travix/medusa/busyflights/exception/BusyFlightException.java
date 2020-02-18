package com.travix.medusa.busyflights.exception;

public class BusyFlightException extends Exception {

    public BusyFlightException() {
    }

    public BusyFlightException(String message) {
        super(message);
    }

    public BusyFlightException(String message, Throwable cause) {
        super(message, cause);
    }
}
