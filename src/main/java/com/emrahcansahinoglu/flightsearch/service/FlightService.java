package com.emrahcansahinoglu.flightsearch.service;

import com.emrahcansahinoglu.flightsearch.exceptions.FlightNotFoundException;
import com.emrahcansahinoglu.flightsearch.models.Flight;
import com.emrahcansahinoglu.flightsearch.repositories.IFlightRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FlightService {
    @Autowired
    public IFlightRepository iFlightRepository;

    public List<Flight> getAllFlights() {
        return iFlightRepository.findAll();
    }

    public Flight getFlightById(Long id) {
        return iFlightRepository.findById(id).orElseThrow(() -> new FlightNotFoundException());
    }

    public Flight saveFlight(Flight flight) {
        return iFlightRepository.save(flight);
    }

    public void deleteFlight(Long id) {
        iFlightRepository.deleteById(id);
    }
}
