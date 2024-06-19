package com.s4sprint1.server.services;

import org.springframework.stereotype.Service;
import com.s4sprint1.server.entities.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service // Service which stores and recalls resources created through the API
public class ResourceService {
    private Map<Integer, Aircraft> aircraft = new HashMap<Integer, Aircraft>();
    private Map<Integer, Airport> airports = new HashMap<Integer, Airport>();
    private final Map<Integer, City> cities = new HashMap<Integer, City>();
    private Map<Integer, Flight> flights = new HashMap<Integer, Flight>();
    private Map<Integer, Passenger> passengers = new HashMap<Integer, Passenger>();

    public City addCity(City newCity) {
        newCity.setId(cities.size() + 1);
        cities.put(newCity.getId(), newCity);

        return newCity;
    };

    public List<City> getAllCities() {
        return List.copyOf(cities.values());
    }

    public City getCity(int id) {
        return cities.get(id);
    }

    public List<Airport> getAllAirports() {
        List<Airport> airports = new ArrayList<Airport>();

        for (City city : cities.values()) {
            airports.addAll(city.getAirports());
        }

        return airports;
    }
}
