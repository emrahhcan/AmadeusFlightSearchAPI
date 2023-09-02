package com.emrahcansahinoglu.flightsearch.utils;

import org.springframework.http.HttpStatus;

import java.util.HashMap;

public class JsonFormat {
    public <T> HashMap<String, T> formatJson(T subContent, HttpStatus status) {
        HashMap<String, T> contentMap = new HashMap<>();
        contentMap.put("contentType", (T) "application/json");
        contentMap.put("content", subContent);
        contentMap.put("status", (T) Integer.valueOf(status.value()));

        return contentMap;
    }
}
