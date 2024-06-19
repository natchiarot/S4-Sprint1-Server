package com.s4sprint1.server.entities;

public class Aircraft {
    private int id;
    private String type;
    private String airlineName;
    private short maxCapacity;

    public int getId() {
        return id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getAirlineName() {
        return airlineName;
    }

    public void setAirlineName(String airlineName) {
        this.airlineName = airlineName;
    }

    public short getMaxCapacity() {
        return maxCapacity;
    }

    public void setMaxCapacity(short maxCapacity) {
        this.maxCapacity = maxCapacity;
    }
}
