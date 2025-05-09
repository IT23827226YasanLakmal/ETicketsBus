package com.eBusTicketsWeb.model;

import java.sql.Date;
import java.sql.Time;

public class ScheduleResult {
	private int id;
    private Time departureTime;
    private Time arrivalTime;
    private Date travelDate;
    private String start;
    private String end;
    
    public ScheduleResult() {}
    
	public ScheduleResult(int id, Time departureTime, Time arrivalTime, Date travelDate, String start, String end) {
		super();
		this.departureTime = departureTime;
		this.arrivalTime = arrivalTime;
		this.travelDate = travelDate;
		this.start = start;
		this.end = end;
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Time getDepartureTime() {
		return departureTime;
	}
	public void setDepartureTime(Time departureTime) {
		this.departureTime = departureTime;
	}
	public Time getArrivalTime() {
		return arrivalTime;
	}
	public void setArrivalTime(Time arrivalTime) {
		this.arrivalTime = arrivalTime;
	}
	public Date getTravelDate() {
		return travelDate;
	}
	public void setTravelDate(Date travelDate) {
		this.travelDate = travelDate;
	}
	public String getStart() {
		return start;
	}
	public void setStart(String start) {
		this.start = start;
	}
	public String getEnd() {
		return end;
	}
	public void setEnd(String end) {
		this.end = end;
	}
    
    
}
