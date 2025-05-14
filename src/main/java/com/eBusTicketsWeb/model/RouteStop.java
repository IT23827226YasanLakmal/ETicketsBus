package com.eBusTicketsWeb.model;

public class RouteStop {
//variables
	private int id;
	private int route_id;
	private String stop_name;
	private int stop_order;
	
	
//Overload constructor
	public RouteStop(int id, int route_id, String stop_name, int stop_order) {
		super();
		this.id = id;
		this.route_id = route_id;
		this.stop_name = stop_name;
		this.stop_order = stop_order;
	}
	
	
//Getters and Setters for the variables
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public int getRoute_id() {
		return route_id;
	}
	
	public void setRoute_id(int route_id) {
		this.route_id = route_id;
	}
	
	public String getStop_name() {
		return stop_name;
	}
	
	public void setStop_name(String stop_name) {
		this.stop_name = stop_name;
	}
	
	public int getStop_order() {
		return stop_order;
	}
	
	public void setStop_order(int stop_order) {
		this.stop_order = stop_order;
	}
	
}