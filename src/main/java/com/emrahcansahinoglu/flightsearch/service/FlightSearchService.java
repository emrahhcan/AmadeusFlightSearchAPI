package com.emrahcansahinoglu.flightsearch.service;

import com.emrahcansahinoglu.flightsearch.models.Flight;
import com.emrahcansahinoglu.flightsearch.models.FlightSearch;
import com.emrahcansahinoglu.flightsearch.repositories.IFlightRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class FlightSearchService {

    private final IFlightRepository iFlightRepository;

    @Autowired
    public FlightSearchService(IFlightRepository iFlightRepository) {
        this.iFlightRepository = iFlightRepository;
    }

    public FlightSearch searchFlights(String departureCity, String arrivalCity, String departureDate, String returnDate) {
        FlightSearch flightSearch = new FlightSearch();

        // Parse date strings to LocalDateTime
        LocalDateTime parsedDepartureDate = LocalDateTime.parse(departureDate);
        LocalDateTime parsedReturnDate = returnDate != null ? LocalDateTime.parse(returnDate) : null;

        // Find one-way flights
        List<Flight> oneWayFlights = iFlightRepository.findByDepartureAirport_CityAndArrivalAirport_CityAndDepartureTimeBetween(
                departureCity, arrivalCity, parsedDepartureDate, parsedDepartureDate.plusDays(1));

        flightSearch.setDepartureCity(departureCity);
        flightSearch.setArrivalCity(arrivalCity);
        flightSearch.setDepartureDate(departureDate);

        if (parsedReturnDate != null) {
            // Find return flights
            List<Flight> returnFlights = iFlightRepository.findByDepartureAirport_CityAndArrivalAirport_CityAndDepartureTimeBetween(
                    arrivalCity, departureCity, parsedReturnDate, parsedReturnDate.plusDays(1));
            flightSearch.setReturnDate(returnDate);
            flightSearch.setReturnFlights(returnFlights);
        }

        flightSearch.setOneWayFlights(oneWayFlights);
        return flightSearch;
    }
}

