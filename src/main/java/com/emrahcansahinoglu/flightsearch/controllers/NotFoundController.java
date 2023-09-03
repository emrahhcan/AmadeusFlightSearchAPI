package com.emrahcansahinoglu.flightsearch.controllers;

import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Controller
public class NotFoundController implements ErrorController {

        @RequestMapping("/error")
        public ResponseEntity<HashMap<String, Object>> handleError() {
                HashMap<String, String> mainEndpoint = new HashMap<>();
                mainEndpoint.put("url", "/api/v1");
                mainEndpoint.put("methods", "GET");
                mainEndpoint.put("description", "Introduction of the API");

                HashMap<String, String> flightsEndpoint = new HashMap<>();
                flightsEndpoint.put("url", "/api/v1/flights");
                flightsEndpoint.put("methods", "GET, POST");
                flightsEndpoint.put("description", "Gets all flights that received from an third party api " +
                                "as well as let admin to create a flight");

                HashMap<String, String> airportsEndpoint = new HashMap<>();
                airportsEndpoint.put("url", "/api/v1/airports");
                airportsEndpoint.put("methods", "GET");
                airportsEndpoint.put("description", "Gets all airports that received from an third party api " +
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

                HashMap<String, Object> content = new HashMap<>();
                content.put("message", "404 - Resource not found");
                content.put("apiInfo", subContent);

                HashMap<String, Object> errorResponse = new HashMap<>();
                errorResponse.put("applicationType", "application/Json");
                errorResponse.put("content", content);
                errorResponse.put("status", HttpStatus.NOT_FOUND.value());

                return ResponseEntity.status(HttpStatus.NOT_FOUND)
                                .body(errorResponse);
        }
}