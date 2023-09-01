package com.emrahcansahinoglu.flightsearch.repositories;

import com.emrahcansahinoglu.flightsearch.models.Flight;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IFlightRepository extends JpaRepository<Flight, Long> { }
