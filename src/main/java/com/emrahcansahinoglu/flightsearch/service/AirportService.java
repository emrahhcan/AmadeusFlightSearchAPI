package com.emrahcansahinoglu.flightsearch.service;

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
}
