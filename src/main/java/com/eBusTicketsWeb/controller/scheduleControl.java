package com.eBusTicketsWeb.controller;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

public class scheduleControl {
	
	
	//DB connection
	private static boolean isSuccess;
	private static Connection con = null;
	private static Statement stmt = null;
	private static ResultSet rs = null;
	
	//Insert data function
	public static boolean insertData(int id, int busId, int routeId, int driverId, LocalTime departure, LocalTime arrival,
			LocalDate travelDate, double fare) {
		
		boolean isSuccess = false;
		
		try {
			
			//DB connection call
			con = DBconnection.getConnection();
			stmt = con.createStatement();
			
			//SQL Query
			String sql = "insert into schedule values (0,'"+busId+"','"+routeId+"','"+driverId+"','"+departure+"','"+arrival+"','"+travelDate+"',"+fare+")";
			
			int rs = stmt.executeUpdate(sql);
			
			if(rs > 0) {
				isSuccess = true;
			}
			else {
				isSuccess = false;
			}
			
		}catch(Exception e){
			
			e.printStackTrace();	
		}
		
		return isSuccess;
	}
	
	//get details from DB
	public static List<scheduleModel> getById (String ID){
		
		int convertedId = Integer.parseInt(ID);
		
		ArrayList <scheduleModel> sc = new ArrayList<>();
			
		try {
			
			//DB connection call
			con = DBconnection.getConnection();
			stmt = con.createStatement();
			
			//Query
			String sql = "select * from schedule where id = '"+convertedId+"'";
			rs = stmt.executeQuery(sql);
			
			while(rs.next()) {
				int id = rs.getInt(1);
				int busId = rs.getInt(2);
				int routeId = rs.getInt(3);
				int driverId = rs.getInt(4);
				String departure = rs.getString(5);
				String arrival = rs.getString(6);
				String travelDate = rs.getString(7);
				double fare = rs.getDouble(8);
				
				LocalTime depTime = LocalTime.parse(departure); // works if format is "HH:mm:ss"
				LocalTime arrTime = LocalTime.parse(arrival);
				LocalDate traveLd = LocalDate.parse(travelDate);
				
				scheduleModel sm = new scheduleModel(id,busId,routeId,driverId,depTime,arrTime,traveLd,fare);
				
				sc.add(sm);
			}
		}catch(Exception e) {
			
			e.printStackTrace();
		}
		
		
		return sc;
	}
	
	//Get all data
	public static List<scheduleModel> getallSchedules(){
		
		ArrayList <scheduleModel> allsc = new ArrayList<>();
		
try {
			
			//DB connection call
			con = DBconnection.getConnection();
			stmt = con.createStatement();
			
			//Query
			String sql = "select * from schedule";
			rs = stmt.executeQuery(sql);
			
			while(rs.next()) {
				int id = rs.getInt(1);
				int busId = rs.getInt(2);
				int routeId = rs.getInt(3);
				int driverId = rs.getInt(4);
				String departure = rs.getString(5);
				String arrival = rs.getString(6);
				String travelDate = rs.getString(7);
				double fare = rs.getDouble(8);
				
				LocalTime depTime = LocalTime.parse(departure); // works if format is "HH:mm:ss"
				LocalTime arrTime = LocalTime.parse(arrival);
				LocalDate traveLd = LocalDate.parse(travelDate);
				
				scheduleModel sm = new scheduleModel(id,busId,routeId,driverId,depTime,arrTime,traveLd,fare);
				
				allsc.add(sm);
			}
	}catch(Exception e) {
	
		e.printStackTrace();
	}


return allsc;
	}
	
	//Update data
	public static boolean updatedata(int id,int busId,int routeId,int driverId,String departure,String arrival,String travelDate,double fare) {
		
		try {
			//DB Connection
			con = DBconnection.getConnection();
			stmt = con.createStatement();
			
			//SQL query
			String sql = "update schedule set bus_id='"+busId+"',route_id='"+routeId+"',driver_id='"+driverId+"',departure_time='"+departure+"',arrival_time='"+arrival+"',travel_date='"+travelDate+"',fare='"+fare+"'"
						+"where id='"+id+"'";
			
			int rs = stmt.executeUpdate(sql);
			
			if(rs > 0) {
				isSuccess = true;
			}
			else {
				isSuccess = false;
			}
			
		}catch(Exception e) {
			
			e.printStackTrace();
		}
		
		return isSuccess;
	}
	
	//Delete data
	public static boolean deletedata(String id) {
		
		int conID = Integer.parseInt(id);
		
		try {
			//DB Connection
			con = DBconnection.getConnection();
			stmt = con.createStatement();
			
			//SQL query
			String sql = "delete from schedule where id='"+conID+"'";
			
			int rs = stmt.executeUpdate(sql);
			
			if(rs > 0) {
				isSuccess = true;
			}
			else {
				isSuccess = false;
			}
			
		}catch(Exception e) {
			
			e.printStackTrace();
		}
			
		
		
		
		return isSuccess;
		
	}
}
