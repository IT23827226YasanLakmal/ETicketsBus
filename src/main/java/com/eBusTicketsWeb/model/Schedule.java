package com.eBusTicketsWeb.model;

import java.sql.Date;
import java.sql.Time;

public class Schedule {
    private int id;
    private int busId;
    private int routeId;
    private int driverId;
    private Time departureTime;
    private Time arrivalTime;
    private Date travelDate;


    // Constructors
    public Schedule() {}

    public Schedule(int id, int busId, int routeId, int driverId, Time departureTime, Time arrivalTime) {
        this.id = id;
        this.busId = busId;
        this.routeId = routeId;
        this.driverId = driverId;
        this.departureTime = departureTime;
        this.arrivalTime = arrivalTime;

    }

    // Getters and Setters
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public int getBusId() { return busId; }
    public void setBusId(int busId) { this.busId = busId; }

    public int getRouteId() { return routeId; }
    public void setRouteId(int routeId) { this.routeId = routeId; }

    public int getDriverId() { return driverId; }
    public void setDriverId(int driverId) { this.driverId = driverId; }

    public Time getDepartureTime() { return departureTime; }
    public void setDepartureTime(Time departureTime) { this.departureTime = departureTime; }

    public Time getArrivalTime() { return arrivalTime; }
    public void setArrivalTime(Time arrivalTime) { this.arrivalTime = arrivalTime; }

    public Date getTravelDate() { return travelDate; }
    public void setTravelDate(Date travelDate) { this.travelDate = travelDate; }

    
}