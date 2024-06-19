package com.s4sprint1.server.services;

import org.springframework.stereotype.Service;
import com.s4sprint1.server.entities.*;

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

    public Airport getAirport(int id) {
        return airports.get(id);
    }

    public List<Airport> getAllAirports() {
        return List.copyOf(airports.values());
    }
}
