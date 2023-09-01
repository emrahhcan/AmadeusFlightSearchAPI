package com.emrahcansahinoglu.flightsearch.exceptions;

public class FlightNotFoundException extends RuntimeException {
    public FlightNotFoundException() {
        super("Could not find flight");
    }
}
