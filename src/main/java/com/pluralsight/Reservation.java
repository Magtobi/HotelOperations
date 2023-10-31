package com.pluralsight;

public class Reservation {
    private String roomType;
    private double pricePerNight;
    private int numberOfNights;
    private boolean isWeekend;

    public Reservation(String roomType, int numberOfNights, boolean isWeekend) {
        this.roomType = roomType;
        this.numberOfNights = numberOfNights;
        this.isWeekend = isWeekend;
        setPricePerNight(roomType);
    }

    public String getRoomType() {
        return roomType;
    }

    public void setRoomType(String roomType) {
        this.roomType = roomType;
        setPricePerNight(roomType);
    }

    public double getPrice() {
        double totalPrice = pricePerNight * numberOfNights;

        if (isWeekend) {
            // Increase price by 10% if it's a weekend stay
            totalPrice *= .10;
        }

        return totalPrice;
    }

    public int getNumberOfNights() {
        return numberOfNights;
    }

    public void setNumberOfNights(int numberOfNights) {
        this.numberOfNights = numberOfNights;
    }

    public boolean isWeekend() {
        return isWeekend;
    }

    public void setIsWeekend(boolean isWeekend) {
        this.isWeekend = isWeekend;
    }

    public double getReservationsTotal() {
        return getPrice();
    }

    private void setPricePerNight(String roomType) {
        if (roomType.equalsIgnoreCase("king")) {
            pricePerNight = 139.00;
        } else if (roomType.equalsIgnoreCase("double")) {
            pricePerNight = 124.00;
        }
    }
}
