package com.s4sprint1.server.services;

import com.s4sprint1.server.entities.*;

import jakarta.websocket.server.PathParam;
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
    @Autowired
    private AircraftService aircraftService;
    @Autowired
    private FlightService flightService;
    @Autowired
    private PassengerService passengerService;

    // Add a new city
    @PostMapping("city")
    public City addCity(@RequestBody City newCity) {
        return cityService.addCity(newCity);
    }

    // Add a list of new cities
    @PostMapping("cities")
    public List<City> addCities(@RequestBody List<City> cities) {
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
    // For example, to associate airport 1 with city 10: /city/10?airport=1
    @PutMapping("city/{cityId}")
    public City moveAirportToCity(@PathVariable int cityId, @RequestParam(value = "airport") int airportId) {
        return cityService.moveAirportToCity(airportService.getAirport(airportId), cityId);
    }

    // Remove an airport association
    @DeleteMapping("city/{cityId}")
    public City removeAirportFromCity(@PathVariable int cityId, @RequestParam(value = "airport") int airportId) {
        return cityService.removeAirportFromCity(airportService.getAirport(airportId), cityId);
    }

    // Add an aircraft
    @PostMapping("aircraft")
    public Aircraft addAircraft(@RequestBody Aircraft newAircraft) {
        return aircraftService.addAircraft(newAircraft);
    }

    // Add a list of aircraft
    @PostMapping("aircraftList")
    public List<Aircraft> addAircraftList(@RequestBody List<Aircraft> newAircraft) {
        return aircraftService.addAircraftList(newAircraft);
    }

    // Get an aircraft
    @GetMapping("aircraft/{id}")
    public Aircraft getAircraft(@PathVariable int id) {
        return aircraftService.getAircraft(id);
    }

    // Get a list of aircraft
    @GetMapping("aircraft")
    public List<Aircraft> getAllAircraft() {
        return aircraftService.getAllAircraft();
    }

    // Move aircraft to a given airport
    @PutMapping("aircraft/{aircraftId}")
    public Aircraft moveAircraftToAirport(@PathVariable int aircraftId, @RequestParam(value = "airport") int airportId) {
        return aircraftService.moveAircraftToAirport(aircraftId, airportId);
    }

    // Get the current location (airport) of an aircraft
    @GetMapping("aircraft/{aircraftId}/location")
    public Airport getAircraftLocation(@PathVariable int aircraftId) {
        Aircraft aircraft = aircraftService.getAircraft(aircraftId);

        return airportService.getAirport(aircraft.getAirportId());
    }

    // Get all possible flight destinations for an aircraft
    // (ie, all airports except the one it is currently located at)
    @GetMapping("aircraft/{aircraftId}/destinations")
    public List<Airport> getAircraftDestinations(@PathVariable int aircraftId) {
        List<Airport> destinations = airportService.getAllAirports();
        int excludedId = aircraftService.getAircraft(aircraftId).getAirportId();
        destinations.remove(airportService.getAirport(excludedId));

        return destinations;
    }

    // Add a passenger
    @PostMapping("passenger")
    public Passenger addPassenger(@RequestBody Passenger newPassenger) {
        return passengerService.addPassenger(newPassenger);
    }

    // Add a list of passengers
    @PostMapping("passengers")
    public List<Passenger> addPassengers(@RequestBody List<Passenger> newPassengers) {
        return passengerService.addPassengers(newPassengers);
    }

    // Get a specific passenger
    @GetMapping("passenger/{id}")
    public Passenger getPassenger(@PathVariable int id) {
        return passengerService.getPassenger(id);
    }

    // Get all passengers
    @GetMapping("passengers")
    public List<Passenger> getPassengers() {
        return passengerService.getAllPassengers();
    }

    // Add a flight
    @PostMapping("flight")
    public Flight addFlight(@RequestBody Flight newFlight) {
        return flightService.addFlight(newFlight);
    }

    // Add a list of flights
    @PostMapping("flights")
    public List<Flight> addFlights(@RequestBody List<Flight> newFlights) {
        return flightService.addFlights(newFlights);
    }

    // Get a specific flight
    @GetMapping("flight/{id}")
    public Flight getFlight(@PathVariable int id) {
        return flightService.getFlight(id);
    }

    // Filter all flights by a parameter
    @GetMapping("flights")
    public List<Flight> getFlights(@RequestParam(value = "find", required = false) String filter, @RequestParam(value = "id", required = false) Integer id) {
        // If no id is supplied, return the full list of flights
        if (id == null)
            return flightService.getAllFlights();

        return switch (filter) {
            case "source" -> flightService.getFlightsFromAirport(id);
            case "destination" -> flightService.getFlightsToAirport(id);
            case "passenger" -> flightService.getFlightsByPassenger(id);
            case "aircraft" -> flightService.getFlightsByAircraft(id);
            default -> flightService.getAllFlights();
        };
    }
}
