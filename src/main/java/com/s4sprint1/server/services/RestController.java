package com.s4sprint1.server.services;

import com.s4sprint1.server.entities.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@org.springframework.web.bind.annotation.RestController
@CrossOrigin
public class RestController {
    @Autowired
    private CityService cityService;
    @Autowired
    private AirportService airportService;

    // Add a new city
    @PostMapping("city")
    public City addCity(@RequestBody City newCity) {
        return cityService.addCity(newCity);
    }

    // Get a list of all cities
    @GetMapping("cities")
    public List<City> getAllCities() {
        return cityService.getAllCities();
    }

    // Add a new airport
    @PostMapping("airport")
    public Airport addAirport(@RequestBody Airport newAirport) {
        return airportService.addAirport(newAirport);
    }

    // Get a list of all airports
    @GetMapping("airports")
    public List<Airport> getAllAirports() {
        return airportService.getAllAirports();
    }
}
