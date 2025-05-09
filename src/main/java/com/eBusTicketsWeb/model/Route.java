package com.eBusTicketsWeb.model;

public class Route {
	
	//Creation variables
 private int id;
 private String source;
 private String destination;
 private float distance_km;
 private String stops;
 private String estimated_time;
 
 //Overloaded constructor
public Route(int id, String source, String destination, float distance_km, String stops,String estimated_time) {
	super();
	this.id = id;
	this.source = source;
	this.destination = destination;
	this.distance_km = distance_km;
	this.stops = stops;
	this.estimated_time = estimated_time;
}

//Getters and Setters
public int getId() {
	return id;
}

public void setId(int id) {
	this.id = id;
}

public String getSource() {
	return source;
}

public void setSource(String source) {
	this.source = source;
}

public String getDestination() {
	return destination;
}

public void setDestination(String destination) {
	this.destination = destination;
}

public float getDistance_km() {
	return distance_km;
}

public void setDistance_km(float distance_km) {
	this.distance_km = distance_km;
}

public String getStops() {
	return stops;
}

public void setStops(String stops) {
	this.stops = stops;
}

public String getEstimated_time() {
	return estimated_time;
}

public void setEstimated_time(String estimated_time) {
	this.estimated_time = estimated_time;
}

}