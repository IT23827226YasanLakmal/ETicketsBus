package com.eBusTicketsWeb.model;


public class Bus {
 private int id;
 private String busNumber;
 private String busType;
 private int totalSeats;
 private int driverId;
 private int routeId;

 // Constructor
 public Bus(int id, String busNumber, String busType, int totalSeats, int driverId, int routeId) {
     this.id = id;
     this.busNumber = busNumber;
     this.busType = busType;
     this.totalSeats = totalSeats;
     this.driverId = driverId;
     this.routeId = routeId;
 }

 public Bus(String busNumber, String busType, int totalSeats, int driverId, int routeId) {
     this.busNumber = busNumber;
     this.busType = busType;
     this.totalSeats = totalSeats;
     this.driverId = driverId;
     this.routeId = routeId;
 }

 // Getters and Setters
 public int getId() { return id; }
 public void setId(int id) { this.id = id; }

 public String getBusNumber() { return busNumber; }
 public void setBusNumber(String busNumber) { this.busNumber = busNumber; }

 public String getBusType() { return busType; }
 public void setBusType(String busType) { this.busType = busType; }

 public int getTotalSeats() { return totalSeats; }
 public void setTotalSeats(int totalSeats) { this.totalSeats = totalSeats; }

 public int getDriverId() { return driverId; }
 public void setDriverId(int driverId) { this.driverId = driverId; }

 public int getRouteId() { return routeId; }
 public void setRouteId(int routeId) { this.routeId = routeId; }
}
