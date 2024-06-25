package com.s4sprint1.server.services;

import org.springframework.stereotype.Service;
import com.s4sprint1.server.entities.Airport;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service // Service to store and recall Airports
public class AirportService {
    private final Map<Integer, Airport> airports = new HashMap<Integer, Airport>();

    public Airport addAirport(Airport newAirport) {
        airports.put(newAirport.getId(), newAirport);

        return newAirport;
    }

    public List<Airport> addAirports(List<Airport> newAirports) {
        for (Airport airport : newAirports)
            airports.put(airport.getId(), airport);

        return newAirports;
    }

    public Airport getAirport(int id) {
        return airports.get(id);
    }

    public List<Airport> getAllAirports() {
        return List.copyOf(airports.values());
    }

    public Airport updateAirport(int id, Airport airport) {
        Airport updatedAirport = airports.get(id);

        updatedAirport.setCode(airport.getCode());
        updatedAirport.setName(airport.getName());

        airports.put(id, updatedAirport);
        return updatedAirport;
    }

    public void deleteAirport(int id) {
        airports.remove(id);
    }
}
