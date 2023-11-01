package com.pluralsight;

public class Hotel {
    private String name;
    private int numberOfSuites;
    private int numberOfRooms;
    private int bookedSuites;
    private int bookedBasicRooms;

    public Hotel(String name, int numberOfRooms, int numberOfSuites) {
        this.name = name;
        this.numberOfRooms = numberOfRooms;
        this.numberOfSuites = numberOfSuites;
        this.bookedSuites = 0;
        this.bookedBasicRooms = 0;
    }
    public Hotel(String name, int numberOfRooms, int numberOfSuites, int bookedSuites, int bookedBasicRooms) {
        this.name = name;
        this.numberOfRooms = numberOfRooms;
        this.numberOfSuites = numberOfSuites;
        this.bookedSuites = 0;
        this.bookedBasicRooms = 0;
    }
    public String getName() {
        return name;
    }
    public int getNumberOfRooms() {
        return numberOfRooms;
    }
    public int getNumberOfSuites() {
        return numberOfSuites;
    }
    public int getBookedSuites() {
        return bookedSuites;
    }
    public int getBookedBasicRooms() {
        return bookedBasicRooms;
    }
    public int getAvailableRooms() {
        return numberOfRooms - bookedBasicRooms;
    }
    public int getAvailableSuites() {
        return numberOfSuites - bookedSuites;
    }
    public boolean isSuiteAvailable() {
        return getAvailableSuites() > 0;
    }
    public boolean isBasicRoomAvailable() {
        return getAvailableRooms() > 0;
    }
    public boolean bookRoom(int numberOfRooms, boolean isSuite) {
        if (isSuite) {
            int availableSuites = getAvailableSuites();
            if (availableSuites >= numberOfRooms) {
                bookedSuites += numberOfRooms;
                return true;
            }
        } else {
            int availableRooms = getAvailableRooms();
            if (availableRooms >= numberOfRooms) {
                bookedBasicRooms += numberOfRooms;
                return true;
            }
        }
        // Room can't be booked
        return false;
    }
}
