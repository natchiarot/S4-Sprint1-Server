package com.s4sprint1.server.services;

import com.s4sprint1.server.entities.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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

    // Add a list of new cities
    @PostMapping("cities")
    public List<City> addCities(List<City> cities) {
        return cityService.addCities(cities);
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

    // Add a list of airports
    @PostMapping("airports")
    public List<Airport> addAirports(@RequestBody List<Airport> newAirports) {
        return airportService.addAirports(newAirports);
    }

    // Get a list of all airports
    @GetMapping("airports")
    public List<Airport> getAllAirports() {
        return airportService.getAllAirports();
    }

    // Associate an airport with a city
    @PutMapping("city/{cityId}/{airportId}")
    public City addAirportToCity(@PathVariable int cityId, @PathVariable int airportId) {
         City targetCity = cityService.getCity(cityId);
         targetCity.linkAirport(airportService.getAirport(airportId));

         return targetCity;
    }

    // Remove an airport association
    @DeleteMapping("city/{cityId}/{airportId}")
    public City removeAirportFromCity(@PathVariable int cityId, @PathVariable int airportId) {
        City targetCity = cityService.getCity(cityId);
        targetCity.unlinkAirport(airportService.getAirport(airportId));

        return targetCity;
    }
}
