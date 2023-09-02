package com.emrahcansahinoglu.flightsearch.models;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "airports")
public class Airport {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "city")
    private String city;

    @OneToMany(mappedBy = "departureAirport")
    private List<Flight> outgoingFlights;

    @OneToMany(mappedBy = "arrivalAirport")
    private List<Flight> incomingFlights;

    public Airport() {}
    public Airport(Long id, String city) {
        this.id = id;
        this.city = city;
    }

    public Long getId() {
        return id;
    }

    public String getCity() {
        return city;
    }
    public void setCity(String city) {
        this.city = city;
    }

    @Override
    public String toString() {
        return "Airport{" +
                "id=" + id +
                ", city='" + city + '\'' +
                '}';
    }
}
