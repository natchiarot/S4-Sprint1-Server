package com.s4sprint1.server.services;

import com.s4sprint1.server.entities.Airport;
import org.springframework.stereotype.Service;
import com.s4sprint1.server.entities.City;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service // Service to store and recall Cities
public class CityService {
    private final Map<Integer, City> cities = new HashMap<Integer, City>();

    public City addCity(City newCity) {
        cities.put(newCity.getId(), newCity);

        return newCity;
    };

    public List<City> addCities(List<City> newCities) {
        for (City city : newCities)
            cities.put(city.getId(), city);

        return newCities;
    }

    public City getCity(int id) {
        return cities.get(id);
    }

    public List<City> getAllCities() {
        return List.copyOf(cities.values());
    }
}
