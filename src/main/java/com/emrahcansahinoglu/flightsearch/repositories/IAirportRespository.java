package com.emrahcansahinoglu.flightsearch.repositories;

import com.emrahcansahinoglu.flightsearch.models.Airport;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IAirportRespository extends JpaRepository<Airport, Long> {
    Airport findByCity(String city);
}
