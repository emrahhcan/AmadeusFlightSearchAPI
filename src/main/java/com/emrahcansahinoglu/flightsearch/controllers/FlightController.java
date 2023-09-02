package com.emrahcansahinoglu.flightsearch.controllers;

import com.emrahcansahinoglu.flightsearch.models.Flight;
import com.emrahcansahinoglu.flightsearch.service.FlightService;
import com.emrahcansahinoglu.flightsearch.utils.JsonFormat;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class FlightController extends BaseController {
    private final FlightService flightService;

    public FlightController(FlightService flightService) {
        this.flightService = flightService;
    }

    @GetMapping("/flights")
    public HashMap<String, Object> getAllFlights() {
        JsonFormat jsonFormat = new JsonFormat();
        return jsonFormat.formatJson(flightService.getAllFlights(), HttpStatus.OK);
    }

    @PostMapping("/flights")
    public Flight createFlight(@RequestBody Flight flight) {
        return flightService.saveFlight(flight);
    }
}