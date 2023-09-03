package com.emrahcansahinoglu.flightsearch.service;

import com.emrahcansahinoglu.flightsearch.exceptions.AirportNotFoundException;
import com.emrahcansahinoglu.flightsearch.models.Airport;
import com.emrahcansahinoglu.flightsearch.repositories.IAirportRespository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AirportService {
    @Autowired
    private final IAirportRespository iAirportRespository;

    @Autowired
    public AirportService(IAirportRespository iAirportRespository) {
        this.iAirportRespository = iAirportRespository;
    }

    public List<Airport> getAllAirposts() {
        return iAirportRespository.findAll();
    }

    public Airport saveAirport(Airport airport) {
        return iAirportRespository.save(airport);
    }

    public Airport getAirportById(Long id) {
        return iAirportRespository.findById(id).orElseThrow(() -> new AirportNotFoundException());
    }

    public void deleteAirportById(Long id) {
        iAirportRespository.deleteById(id);
    }

    public Airport updateAirport(Long id, Airport airport) {
        Airport airportToUpdate = iAirportRespository.findById(id).orElseThrow(() -> new AirportNotFoundException());

        airportToUpdate.setCity(airport.getCity());

        return iAirportRespository.save(airportToUpdate);
    }
}
