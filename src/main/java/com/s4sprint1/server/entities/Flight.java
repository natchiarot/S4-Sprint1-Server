package com.s4sprint1.server.entities;

public class Flight {
    private int id;
    private String expDeparture;
    private String expArrival;
    private int fromAirportId;
    private int toAirportId;
    private int aircraftId;
    private int passengerId;

    public int getId() {
        return id;
    }

    public void setId(int id) { this.id = id; }

    public String getExpDeparture() {
        return expDeparture;
    }

    public void setExpDeparture(String expDeparture) {
        this.expDeparture = expDeparture;
    }

    public String getExpArrival() {
        return expArrival;
    }

    public void setExpArrival(String expArrival) {
        this.expArrival = expArrival;
    }

    public int getFromAirportId() {
        return fromAirportId;
    }

    public void setFromAirportId(int fromAirportId) {
        this.fromAirportId = fromAirportId;
    }

    public int getToAirportId() {
        return toAirportId;
    }

    public void setToAirportId(int toAirportId) {
        this.toAirportId = toAirportId;
    }

    public int getAircraftId() {
        return aircraftId;
    }

    public void setAircraftId(int aircraftId) {
        this.aircraftId = aircraftId;
    }

    public int getPassengerId() {
        return passengerId;
    }

    public void setPassengerId(int passengerId) {
        this.passengerId = passengerId;
    }
}
