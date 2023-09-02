package com.emrahcansahinoglu.flightsearch.service;

import com.emrahcansahinoglu.flightsearch.models.Airport;
import com.emrahcansahinoglu.flightsearch.models.Flight;
import com.emrahcansahinoglu.flightsearch.utils.FlightResponse;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;

@Service
public class FlightDataUpdateService {
    private final FlightService flightService;
    private final AirportService airportService;
    private final RestTemplate restTemplate;

    @Autowired
    public FlightDataUpdateService(FlightService flightService, AirportService airportService, RestTemplate restTemplate) {
        this.flightService = flightService;
        this.airportService = airportService;
        this.restTemplate = restTemplate;
    }

    @PostConstruct
    public void updateFlightDataOnInitialRun() {
        updateFlightData();
    }

    @Scheduled(cron = "0 20 * * * *")
    public void updateFlightDataOnSchedule() {
        updateFlightData();
    }

    public void updateFlightData() {
        String apiUrl = "http://localhost:3000/api/v1/flights";
        ResponseEntity<Flight[]> response = restTemplate.getForEntity(apiUrl, Flight[].class);

        if (response.getStatusCode() == HttpStatus.OK) {
            Flight[] flights = response.getBody();

            for (Flight flight : flights) {
                Airport departureAirport = airportService.saveAirport(flight.getDepartureAirport());
                Airport arrivalAirport = airportService.saveAirport(flight.getArrivalAirport());

                flight.setDepartureAirport(departureAirport);
                flight.setArrivalAirport(arrivalAirport);

                flightService.saveFlight(flight);
            }
        } else {
            System.out.println("Failed to fetch flight data: " + response.getStatusCode());
        }
    }
}
