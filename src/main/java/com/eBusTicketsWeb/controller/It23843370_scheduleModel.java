package com.eBusTicketsWeb.controller;

import java.time.LocalTime;
import java.time.LocalDate;

public class It23843370_scheduleModel {
	
	private int id;
	private int busId;
	private int routeId;
	private int driverId;
	private LocalTime departure;
	private LocalTime arrival;
	private LocalDate travelDate;
	//private double fare;
	
	public It23843370_scheduleModel(int id, int busId, int routeId, int driverId, LocalTime departure, LocalTime arrival,
			LocalDate travelDate) {
		
		this.id = id;
		this.busId = busId;
		this.routeId = routeId;
		this.driverId = driverId;
		this.departure = departure;
		this.arrival = arrival;
		this.travelDate = travelDate;
		//this.fare = fare;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getBusId() {
		return busId;
	}

	public void setBusId(int busId) {
		this.busId = busId;
	}

	public int getRouteId() {
		return routeId;
	}

	public void setRouteId(int routeId) {
		this.routeId = routeId;
	}

	public int getDriverId() {
		return driverId;
	}

	public void setDriverId(int driverId) {
		this.driverId = driverId;
	}

	public LocalTime getDeparture() {
		return departure;
	}

	public void setDeparture(LocalTime departure) {
		this.departure = departure;
	}

	public LocalTime getArrival() {
		return arrival;
	}

	public void setArrival(LocalTime arrival) {
		this.arrival = arrival;
	}

	public LocalDate getTravelDate() {
		return travelDate;
	}

	public void setTravelDate(LocalDate travelDate) {
		this.travelDate = travelDate;
	}

	/*public double getFare() {
		return fare;
	}

	public void setFare(double fare) {
		this.fare = fare;*/
	}
	
	

	
	
	

