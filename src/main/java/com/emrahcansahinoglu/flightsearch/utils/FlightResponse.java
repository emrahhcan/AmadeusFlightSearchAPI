package com.emrahcansahinoglu.flightsearch.utils;

import com.emrahcansahinoglu.flightsearch.models.Flight;

public class FlightResponse {
    private Flight[] content;

    public Flight[] getContent() {
        return content;
    }

    public void setContent(Flight[] content) {
        this.content = content;
    }
}
