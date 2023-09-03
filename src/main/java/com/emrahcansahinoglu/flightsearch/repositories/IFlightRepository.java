package com.emrahcansahinoglu.flightsearch.repositories;

import com.emrahcansahinoglu.flightsearch.models.Flight;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDateTime;
import java.util.List;

public interface IFlightRepository extends JpaRepository<Flight, Long> {
    List<Flight> findByDepartureAirport_CityAndArrivalAirport_CityAndDepartureTimeBetween(
            String departureCity, String arrivalCity, LocalDateTime departureStartTime, LocalDateTime departureEndTime);
}
