package com.s4sprint1.server.services;

import org.springframework.stereotype.Service;
import com.s4sprint1.server.entities.Aircraft;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service // Service to store and recall Aircraft
public class AircraftService {
    private final Map<Integer, Aircraft> aircraftMap = new HashMap<Integer, Aircraft>();

    public Aircraft addAircraft(Aircraft newAircraft) {
        aircraftMap.put(newAircraft.getId(), newAircraft);

        return newAircraft;
    }

    public List<Aircraft> addAircraftList(List<Aircraft> newAircraft) {
        for (Aircraft aircraft : newAircraft)
            aircraftMap.put(aircraft.getId(), aircraft);

        return newAircraft;
    }

    public Aircraft getAircraft(int id) {
        return aircraftMap.get(id);
    }

    public List<Aircraft> getAllAircraft() {
        return List.copyOf(aircraftMap.values());
    }

    public Aircraft moveAircraftToAirport(int aircraftId, int airportId) {
        Aircraft targetAircraft = getAircraft(aircraftId);
        targetAircraft.setAirportId(airportId);

        return targetAircraft;
    }
}
