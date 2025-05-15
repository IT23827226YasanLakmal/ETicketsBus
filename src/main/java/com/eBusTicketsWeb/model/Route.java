package com.eBusTicketsWeb.model;

public class Route {
	
//variables
  int id;
  String start;
  String end;
  float distance_km;
 
//Overloaded constructor
   public Route(int id, String start, String end, float distance_km) {
	   super();
	   this.id = id;
	   this.start = start;
	   this.end = end;
	   this.distance_km = distance_km;
   }

//Getters and Setters for variables
   public int getId() {
	   return id;
   }

   public void setId(int id) {
	   this.id = id;
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

   public float getDistance_km() {
	   return distance_km;
   }

   public void setDistance_km(float distance_km) {
	   this.distance_km = distance_km;
   }

}