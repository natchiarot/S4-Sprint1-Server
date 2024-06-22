package com.s4sprint1.server.services;

import com.s4sprint1.server.entities.Flight;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service // Service to store and recall Flights
public class FlightService {
    private final Map<Integer, Flight> flights = new HashMap<Integer, Flight>();

    public Flight addFlight(Flight newFlight) {
        flights.put(newFlight.getId(), newFlight);

        return newFlight;
    }

    public List<Flight> addFlights(List<Flight> newFlights) {
        for (Flight flight : newFlights)
            flights.put(flight.getId(), flight);

        return newFlights;
    }

    public Flight getFlight(int id) {
        return flights.get(id);
    }

    public List<Flight> getAllFlights() {
        return List.copyOf(flights.values());
    }

    public List<Flight> getFlightsFromAirport(int id) {
        List<Flight> results = new ArrayList<Flight>();

        for (Flight flight : flights.values()) {
            if (flight.getFromAirportId() == id)
                results.add(flight);
        }

        return results;
    }

    public List<Flight> getFlightsToAirport(int id) {
        List<Flight> results = new ArrayList<Flight>();

        for (Flight flight : flights.values()) {
            if (flight.getToAirportId() == id)
                results.add(flight);
        }

        return results;
    }

    public List<Flight> getFlightsByPassenger(int id) {
        List<Flight> results = new ArrayList<Flight>();

        for (Flight flight : flights.values()) {
            if (flight.getPassengerId() == id)
                results.add(flight);
        }

        return results;
    }

    public List<Flight> getFlightsByAircraft(int id) {
        List<Flight> results = new ArrayList<Flight>();

        for (Flight flight : flights.values()) {
            if (flight.getAircraftId() == id)
                results.add(flight);
        }

        return results;
    }
}
