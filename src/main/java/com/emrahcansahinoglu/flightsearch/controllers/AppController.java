package com.emrahcansahinoglu.flightsearch.controllers;

import com.emrahcansahinoglu.flightsearch.utils.JsonFormat;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@RestController
public class AppController extends BaseController {
    @GetMapping({"", "/"})
    public HashMap<String, Object> info() {
        HashMap<String, String> mainEndpoint = new HashMap<>();
        mainEndpoint.put("url","/api/v1");
        mainEndpoint.put("methods","GET");
        mainEndpoint.put("description","Introduction of the API");

        HashMap<String, String> flightsEndpoint = new HashMap<>();
        flightsEndpoint.put("url","/api/v1/flights");
        flightsEndpoint.put("methods","GET, POST");
        flightsEndpoint.put("description","Gets all flights that received from an third party api " +
                "as well as let admin to create a flight");

        HashMap<String, String> airportsEndpoint = new HashMap<>();
        airportsEndpoint.put("url","/api/v1/airports");
        airportsEndpoint.put("methods","GET");
        airportsEndpoint.put("description","Gets all airports that received from an third party api " +
                "as well as let admin to create an airport");

        List<Object> endpoints = new ArrayList<>();
        endpoints.add(mainEndpoint);
        endpoints.add(flightsEndpoint);
        endpoints.add(airportsEndpoint);

        HashMap<String, Object> subContent = new HashMap<>();
        subContent.put("description",
        "Flight search API case study of Amadeus Travel to Future Program");
        subContent.put("versions", "v1");
        subContent.put("URI", "http://localhost:8080/api/v1");
        subContent.put("endpoints", endpoints);

        JsonFormat jsonFormat = new JsonFormat();
        return jsonFormat.formatJson(subContent, HttpStatus.OK);
    }
}
