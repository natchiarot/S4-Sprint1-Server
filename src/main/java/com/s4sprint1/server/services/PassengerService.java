package com.s4sprint1.server.services;

import org.springframework.stereotype.Service;
import com.s4sprint1.server.entities.Passenger;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service // Service to store and recall Passengers
public class PassengerService {
    Map<Integer, Passenger> passengers = new HashMap<Integer, Passenger>();

    public Passenger addPassenger(Passenger newPassenger) {
        passengers.put(newPassenger.getId(), newPassenger);

        return newPassenger;
    }

    public Passenger getPassenger(int id) {
        return passengers.get(id);
    }

    public List<Passenger> getAllPassengers() {
        return List.copyOf(passengers.values());
    }
}
