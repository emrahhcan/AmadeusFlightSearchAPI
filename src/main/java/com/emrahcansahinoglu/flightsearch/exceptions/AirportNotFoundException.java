package com.emrahcansahinoglu.flightsearch.exceptions;

public class AirportNotFoundException extends RuntimeException {
    public AirportNotFoundException() {
        super("There is no such airport");
    }
}
