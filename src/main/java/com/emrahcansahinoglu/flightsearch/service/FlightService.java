package com.emrahcansahinoglu.flightsearch.service;

import com.emrahcansahinoglu.flightsearch.exceptions.FlightNotFoundException;
import com.emrahcansahinoglu.flightsearch.models.Flight;
import com.emrahcansahinoglu.flightsearch.repositories.IFlightRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FlightService {
    private final IFlightRepository iFlightRepository;

    @Autowired
    public FlightService(IFlightRepository iFlightRepository) {
        this.iFlightRepository = iFlightRepository;
    }

    public List<Flight> getAllFlights() {
        return iFlightRepository.findAll();
    }

    public Flight getFlightById(Long id) {
        return iFlightRepository.findById(id).orElseThrow(() -> new FlightNotFoundException());
    }

    public Flight saveFlight(Flight flight) {
        return iFlightRepository.save(flight);
    }

    public void deleteFlightById(Long id) {
        iFlightRepository.deleteById(id);
    }

    public Flight updateFlight(Long id, Flight flight) {
        Flight flightToUpdate = iFlightRepository.findById(id).orElseThrow(() -> new FlightNotFoundException());

        flightToUpdate.setDepartureAirport(flight.getDepartureAirport());
        flightToUpdate.setArrivalAirport(flight.getArrivalAirport());
        flightToUpdate.setDepartureTime(flight.getDepartureTime());
        flightToUpdate.setArrivalTime(flight.getArrivalTime());
        flightToUpdate.setPrice(flight.getPrice());

        return iFlightRepository.save(flightToUpdate);
    }
}
