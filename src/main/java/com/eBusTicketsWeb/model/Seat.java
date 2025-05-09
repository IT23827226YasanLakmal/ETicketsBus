package com.eBusTicketsWeb.model;

public class Seat {
    private int id;
    private int busId;
    private String seatNumber;
    private String seatType;
    private String availability;

    // Constructors
    public Seat() {}

    public Seat(int id, int busId, String seatNumber, String seatType, String availability) {
        this.id = id;
        this.busId = busId;
        this.seatNumber = seatNumber;
        this.seatType = seatType;
        this.availability = availability;
    }

    // Getters and Setters
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public int getBusId() { return busId; }
    public void setBusId(int busId) { this.busId = busId; }

    public String getSeatNumber() { return seatNumber; }
    public void setSeatNumber(String seatNumber) { this.seatNumber = seatNumber; }

    public String getSeatType() { return seatType; }
    public void setSeatType(String seatType) { this.seatType = seatType; }

    public String getAvailability() { return availability; }
    public void setAvailability(String availability) { this.availability = availability; }
}
