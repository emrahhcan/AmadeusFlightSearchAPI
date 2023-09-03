package com.emrahcansahinoglu.flightsearch.models;

import java.util.List;

public class FlightSearch {
    private String departureCity;
    private String arrivalCity;
    private String departureDate;
    private String returnDate;
    private List<Flight> oneWayFlights;
    private List<Flight> returnFlights;

    public String getDepartureCity() {
        return departureCity;
    }

    public void setDepartureCity(String departureCity) {
        this.departureCity = departureCity;
    }

    public String getArrivalCity() {
        return arrivalCity;
    }

    public void setArrivalCity(String arrivalCity) {
        this.arrivalCity = arrivalCity;
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

    public List<Flight> getOneWayFlights() {
        return oneWayFlights;
    }

    public void setOneWayFlights(List<Flight> oneWayFlights) {
        this.oneWayFlights = oneWayFlights;
    }

    public List<Flight> getReturnFlights() {
        return returnFlights;
    }

    public void setReturnFlights(List<Flight> returnFlights) {
        this.returnFlights = returnFlights;
    }
}
