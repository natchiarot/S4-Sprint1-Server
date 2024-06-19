package com.s4sprint1.server.entities;

public class Flight {
    private int id;
    private String date;
    private String expDeparture;
    private String expArrival;
    private int airportId;
    private int aircraftId;
    private int passengerId;

    public int getId() {
        return id;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

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

    public int getAirportId() {
        return airportId;
    }

    public void setAirportId(int airportId) {
        this.airportId = airportId;
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
