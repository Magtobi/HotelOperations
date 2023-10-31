package com.pluralsight;

public class Room {
    private int numberOfBeds;
    private double price;
    private boolean occupied;
    private boolean dirty;

    public Room(int beds, double cost) {
        numberOfBeds = beds;
        price = cost;
        occupied = false;
        dirty = false;
    }

    public int getNumberOfBeds() {
        return numberOfBeds;
    }

    public double getPrice() {
        return price;
    }

    public boolean isOccupied() {
        return occupied;
    }

    public void setOccupied(boolean isOccupied) {
        occupied = isOccupied;
    }

    public boolean isDirty() {
        return dirty;
    }

    public void setDirty(boolean isDirty) {
        dirty = isDirty;
    }

    public boolean isAvailable() {
        return !occupied && !dirty;
    }
    public void checkIn() {
        if (!occupied) {
            occupied = true;
            dirty = true;
        } else {
            System.out.println("Room is occupied. Cannot check in.");
        }
    }
    public void checkOut() {
        if (!occupied) {
            occupied = false;
            System.out.println("Guest has checked out. The room is now available.");
        } else {
            System.out.println("Room is not occupied. No need to check out.");
        }
    }
    public void cleanRoom() {
        if (dirty) {
            dirty = false;
            System.out.println("The room has been cleaned and is now ready.");
        } else {
            System.out.println("The room is already clean.");
        }
    }
}
