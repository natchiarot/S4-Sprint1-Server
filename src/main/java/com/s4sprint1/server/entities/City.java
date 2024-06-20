package com.s4sprint1.server.entities;

import java.util.HashMap;
import java.util.List;

public class City {
    private int id;
    private String name;
    private String state;
    private int population;
    private final HashMap<Integer, Airport> airports = new HashMap<Integer, Airport>();

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public int getPopulation() {
        return population;
    }

    public void setPopulation(int population) {
        this.population = population;
    }

    public List<Airport> getAirports() {
        return List.copyOf(airports.values());
    }

    public void linkAirport(Airport airport) {
        airports.put(airport.getId(), airport);
    }

    public void unlinkAirport(Airport airport) {
        airports.remove(airport.getId());
    }
}
