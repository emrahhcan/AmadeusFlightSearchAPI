package com.emrahcansahinoglu.flightsearch.controllers;

import com.emrahcansahinoglu.flightsearch.models.Airport;
import com.emrahcansahinoglu.flightsearch.models.Flight;
import com.emrahcansahinoglu.flightsearch.service.AirportService;
import com.emrahcansahinoglu.flightsearch.service.FlightService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class FlightController extends BaseController {
    private final FlightService flightService;
    private final AirportService airportService;

    public FlightController(FlightService flightService, AirportService airportService) {
        this.flightService = flightService;
        this.airportService = airportService;
    }

    @GetMapping("/flights")
    public ResponseEntity<?> getAllFlights() {
        try {
            List<Flight> flights = flightService.getAllFlights();
            return ResponseEntity.ok(flights);
        } catch (Exception error) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(error.getMessage());
        }
    }

    @GetMapping("/flights/{id}")
    public ResponseEntity<?> getFlightById(@PathVariable Long id) {
        try {
            Flight flight = flightService.getFlightById(id);
            return ResponseEntity.ok(flight);
        } catch (Exception error) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(error.getMessage());
        }
    }

    @PostMapping("/flights")
    public ResponseEntity<?> createFlight(@RequestBody Flight flight) {
        try {
            Airport departureAirport = airportService.getAirportById(flight.getDepartureAirport().getId());
            Airport arrivalAirport = airportService.getAirportById(flight.getArrivalAirport().getId());

            flight.setDepartureAirport(departureAirport);
            flight.setArrivalAirport(arrivalAirport);

            Flight createdFlight = flightService.saveFlight(flight);
            return ResponseEntity.status(HttpStatus.CREATED).body(createdFlight);
        } catch (Exception error) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(error.getMessage());
        }
    }

    @DeleteMapping("/flights/{id}")
    public ResponseEntity<?> deleteFlight(@PathVariable Long id) {
        try {
            flightService.deleteFlightById(id);
            return ResponseEntity.status(HttpStatus.NO_CONTENT).body(null);
        } catch (Exception error) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(error.getMessage());
        }
    }

    @PutMapping("/flights/{id}")
    public ResponseEntity<?> updateFlight(@PathVariable Long id, @RequestBody Flight flight) {
        try {
            Flight updatedFlight = flightService.getFlightById(id);

            Airport departureAirport = airportService.getAirportById(flight.getDepartureAirport().getId());
            Airport arrivalAirport = airportService.getAirportById(flight.getArrivalAirport().getId());

            updatedFlight.setDepartureAirport(departureAirport);
            updatedFlight.setArrivalAirport(arrivalAirport);
            updatedFlight.setDepartureTime(flight.getDepartureTime());
            updatedFlight.setArrivalTime(flight.getArrivalTime());
            updatedFlight.setPrice(flight.getPrice());
            updatedFlight.setCurrency(flight.getCurrency());

            flightService.saveFlight(updatedFlight);
            return ResponseEntity.ok(updatedFlight);
        } catch (Exception error) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(error.getMessage());
        }
    }
}