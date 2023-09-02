package com.emrahcansahinoglu.flightsearch.controllers;

import com.emrahcansahinoglu.flightsearch.models.Airport;
import com.emrahcansahinoglu.flightsearch.service.AirportService;
import com.emrahcansahinoglu.flightsearch.utils.JsonFormat;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;

@RestController
public class AirportController extends BaseController {
    private final AirportService airportService;

    @Autowired
    public AirportController(AirportService airportService) {
        this.airportService = airportService;
    }

    @GetMapping("/airports")
    public HashMap<String, Object> getAllAirports() {
        JsonFormat jsonFormat = new JsonFormat();
        return jsonFormat.formatJson(airportService.getAllAirposts(), HttpStatus.OK);
    }
}
