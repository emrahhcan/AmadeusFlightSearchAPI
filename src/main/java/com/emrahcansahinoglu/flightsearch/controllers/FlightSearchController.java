package com.emrahcansahinoglu.flightsearch.controllers;

import com.emrahcansahinoglu.flightsearch.models.FlightSearch;
import com.emrahcansahinoglu.flightsearch.service.FlightSearchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FlightSearchController extends BaseController {
    private final FlightSearchService flightSearchService;

    @Autowired
    public FlightSearchController(FlightSearchService flightSearchService) {
        this.flightSearchService = flightSearchService;
    }

    @GetMapping("/search")
    public ResponseEntity<FlightSearch> searchFlights(
            @RequestParam String departureCity,
            @RequestParam String arrivalCity,
            @RequestParam String departureDate,
            @RequestParam(required = false) String returnDate) {
        FlightSearch result = flightSearchService.searchFlights(departureCity, arrivalCity, departureDate, returnDate);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

}
