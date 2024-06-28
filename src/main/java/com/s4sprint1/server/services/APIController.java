package com.s4sprint1.server.services;

import com.s4sprint1.server.entities.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
public class APIController {
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

    // Get a specific city
    @GetMapping("city/{cityId}")
    public City getCity(@PathVariable int cityId) {
        return cityService.getCity(cityId);
    }

    // Get a list of all cities
    @GetMapping("cities")
    public List<City> getAllCities() {
        return cityService.getAllCities();
    }

    // Update a city
    @PutMapping("city/{id}")
    public City updateCity(@PathVariable int id, @RequestBody City city) {
        return cityService.updateCity(id, city);
    }

    // Delete a city
    @DeleteMapping("city/{id}")
    public void deleteCity(@PathVariable int id) {
        // If a city is deleted, all airports in that city must also be deleted.
        City toDelete = cityService.getCity(id);
        for (Airport airport : toDelete.getAirports())
            airportService.deleteAirport(airport.getId());

        cityService.deleteCity(id);
    }

    // Add a new airport
    @PostMapping("airport")
    public Airport addAirport(@RequestBody Airport newAirport) {
        return airportService.addAirport(newAirport);
    }

    // Get an airport
    @GetMapping("airport/{airportId}")
    public Airport getAirport(@PathVariable int airportId) {
        return airportService.getAirport(airportId);
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
    @PutMapping("city/{cityId}/airport/{airportId}")
    public City moveAirportToCity(@PathVariable int cityId, @PathVariable int airportId) {
        return cityService.moveAirportToCity(airportService.getAirport(airportId), cityId);
    }

    // Remove an airport association
    @DeleteMapping("city/{cityId}/airport/{airportId}")
    public City removeAirportFromCity(@PathVariable int cityId, @PathVariable int airportId) {
        return cityService.removeAirportFromCity(airportService.getAirport(airportId), cityId);
    }

    // Update an airport
    @PutMapping("airport/{id}")
    public Airport updateAirport(@PathVariable int id, @RequestBody Airport airport) {
        return airportService.updateAirport(id, airport);
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

    // Get the current location (airport) of an aircraft
    @GetMapping("aircraft/{aircraftId}/location")
    public Airport getAircraftLocation(@PathVariable int aircraftId) {
        Aircraft aircraft = aircraftService.getAircraft(aircraftId);

        return airportService.getAirport(aircraft.getAirportId());
    }

    // Update an aircraft
    @PutMapping("aircraft/{aircraftId}")
    public Aircraft updateAircraft(@PathVariable int aircraftId, @RequestBody Aircraft aircraft) {
        return aircraftService.updateAircraft(aircraftId, aircraft);
    }

    // Delete an aircraft
    @DeleteMapping("aircraft/{aircraftId}")
    public void deleteAircraft(@PathVariable int aircraftId) {
        aircraftService.deleteAircraft(aircraftId);
    }

    // Get all possible flight destinations for an aircraft
    // (ie, all airports except the one it is currently located at)
    @GetMapping("aircraft/{aircraftId}/destinations")
    public List<Airport> getAircraftDestinations(@PathVariable int aircraftId) {
        int excludedId = aircraftService.getAircraft(aircraftId).getAirportId();
        List<Airport> destinations = airportService.getAllAirportsExcept(excludedId);

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

    // Update a passenger
    @PutMapping("passenger/{passengerId}")
    public Passenger updatePassenger(@PathVariable int passengerId, @RequestBody Passenger passenger) {
        return passengerService.updatePassenger(passengerId, passenger);
    }

    // Delete a passenger
    @DeleteMapping("passenger/{passengerId}")
    public void deletePassenger(@PathVariable int passengerId) {
        passengerService.deletePassenger(passengerId);
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
