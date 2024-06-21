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
        Airport targetAirport = airportService.getAirport(airportId);

        // An airport can only exist in one city, ensure this rule is enforced
        // (Airports shouldn't move in the first place, but...)
        for (City city : cityService.getAllCities()) {
            if (city.getId() == cityId)
                city.linkAirport(targetAirport);
            else
                city.unlinkAirport(targetAirport);
        }

        City targetCity = cityService.getCity(cityId);
        targetCity.linkAirport(targetAirport);

        return targetCity;
    }

    // Remove an airport association
    @DeleteMapping("city/{cityId}")
    public City removeAirportFromCity(@PathVariable int cityId, @RequestParam(value = "airport") int airportId) {
        City targetCity = cityService.getCity(cityId);
        targetCity.unlinkAirport(airportService.getAirport(airportId));

        return targetCity;
    }

    // Add an aircraft
    @PostMapping("aircraft")
    public Aircraft addAircraft(Aircraft newAircraft) {
        aircraftService.addAircraft(newAircraft);

        return newAircraft;
    }

    // Add a list of aircraft
    @PostMapping("aircraft")
    public List<Aircraft> addAircraftList(List<Aircraft> newAircraft) {
            return aircraftService.addAircraftList(newAircraft);
    }

    // Get a list of aircraft
    @GetMapping("aircraft")
    public List<Aircraft> getAircraft() {
        return aircraftService.getAllAircraft();
    }

    // Move aircraft to a given airport
    @PutMapping("aircraft/{aircraftId}")
    public Aircraft moveAircraftToAirport(@PathVariable int aircraftId, @RequestParam(value = "airport") int airportId) {
        Aircraft targetAircraft = aircraftService.getAircraft(aircraftId);
        targetAircraft.setAirportId(airportId);

        return targetAircraft;
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
        destinations.remove(airportService.getAirport(aircraftId));

        return destinations;
    }

    // Add a passenger
    @PostMapping("passenger")
    public Passenger addPassenger(@RequestBody Passenger newPassenger) {
        passengerService.addPassenger(newPassenger);

        return newPassenger;
    }

    // Add a list of passengers
    @PostMapping("passengers")
    public List<Passenger> addPassengers(@RequestBody List<Passenger> newPassengers) {
        passengerService.addPassengers(newPassengers);

        return newPassengers;
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

    // Get all flights
    @GetMapping("flights")
    public List<Flight> getFlights() {
        return flightService.getAllFlights();
    }

    // Get all flights from a given airport
    @GetMapping("flights")
    public List<Flight> getFlightsBySource(@RequestParam(value = "source") int source) {
        return flightService.getFlightsFromAirport(source);
    }

    // Get all flights to a given airport
    @GetMapping("flights")
    public List<Flight> getFlightsByDestination(@RequestParam(value = "destination") int destination) {
        return flightService.getFlightsToAirport(destination);
    }

    // Get all flights a given passenger has taken
    @GetMapping("flights")
    public List<Flight> getFlightsByPassenger(@RequestParam(value = "passenger") int passenger) {
        return flightService.getFlightsByPassenger(passenger);
    }

    // Get all flights by a given aircraft
    @GetMapping("flights")
    public List<Flight> getFlightsByAircraft(@RequestParam(value = "aircraft") int aircraft) {
        return flightService.getFlightsByAircraft(aircraft);
    }
}
