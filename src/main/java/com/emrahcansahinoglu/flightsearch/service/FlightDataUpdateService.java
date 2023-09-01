package com.emrahcansahinoglu.flightsearch.service;

import com.emrahcansahinoglu.flightsearch.models.Flight;
import com.emrahcansahinoglu.flightsearch.service.FlightService;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class FlightDataUpdateService {
    private final FlightService flightService;
    private final RestTemplate restTemplate;

    @Autowired
    public FlightDataUpdateService(FlightService flightService, RestTemplate restTemplate) {
        this.flightService = flightService;
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
                flightService.saveFlight(flight);
                System.out.println(flights);
            }
        } else {
            System.out.println("Failed to fetch flight data: " + response.getStatusCode());
        }
    }
}
