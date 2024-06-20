package com.s4sprint1.server.entities;

public class Passenger {
    private int id;
    private String firstName;
    private String lastName;
    private String phoneNumber;
    private int homeCityId;

    public int getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public int getHomeCityId() {
        return homeCityId;
    }

    public void setHomeCityId(int homeCityId) {
        this.homeCityId = homeCityId;
    }
}
