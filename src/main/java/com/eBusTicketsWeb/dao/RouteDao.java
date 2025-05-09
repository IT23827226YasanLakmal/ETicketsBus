package com.eBusTicketsWeb.dao;

import com.eBusTicketsWeb.util.DBConnection;
import com.eBusTicketsWeb.model.Route;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class RouteDao {
	//Connect database
	private static boolean isSuccess;
	private static Connection con=null;
	private static Statement stmt=null;
	private static ResultSet rst=null;
	
	//Create function to Tnsert new route details
	public static boolean insertRoute(String source, String destination, float distance_km, String stops,String estimated_time) {
		boolean isSuccess=false;
		try {
			//Database connection call
			con= DBConnection.getConnection();
			stmt= con.createStatement();
			
			//SQL query
			String sql= "INSERT INTO route VALUES(0,'"+source+"','"+destination+"','"+distance_km+"','"+stops+"','"+estimated_time+"')";
			int rst=stmt.executeUpdate(sql);
			if(rst>0) {
				isSuccess=true;
			}
			else {
				isSuccess=false;
			}
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		return isSuccess;
	}
	
	//Create function to Display route details
	//Get By ID
	public static List <Route>getById (int Id){
	
		ArrayList <Route> route= new ArrayList<>();
		try {
			//DB connection
			con=DBConnection.getConnection();
			stmt=con.createStatement();
			
			//SQL query
			String sql="SELECT* FROM route WHERE id '"+Id+"'";
			rst =stmt.executeQuery(sql);
			
			while(rst.next()) {
				int id=rst.getInt(1);
				String source= rst.getString(2);
				String destination= rst.getString(3);
				float distance_km=rst.getFloat(4);
				String stops= rst.getString(5);
				String estimated_time=rst.getString(6);
				
                Route routeDetail= new Route(id,source,destination,distance_km,stops,estimated_time) ;
                route.add(routeDetail);
			}
				
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return route;	
	}

	//Get all route details
	public static List <Route>getAllRoutes(){
		ArrayList <Route> routes= new ArrayList<>();
		try {
			//DB connection
			con=DBConnection.getConnection();
			stmt=con.createStatement();
			
			//SQL query
			String sql="SELECT* FROM route";
			rst =stmt.executeQuery(sql);
			
			while(rst.next()) {
				int id=rst.getInt(1);
				String source= rst.getString(2);
				String destination= rst.getString(3);
				float distance_km=rst.getFloat(4);
				String stops= rst.getString(5);
				String estimated_time=rst.getString(6);
				
                Route routeDetails= new Route(id,source,destination,distance_km,stops,estimated_time) ;
                routes.add(routeDetails);
			}
				
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return routes;
	}
	
	//Create function to Update route details
	
public static boolean updateDetails(int id,String source, String destination,float distance_km, String stops,String estimated_time) {
	try {
		//DB connection
		con=DBConnection.getConnection();
		stmt=con.createStatement();
		//SQL query
		String sql="UPDATE route SET source='"+source+"',destination='"+destination+"',distance_km='"+distance_km+"',stops='"+stops+"',estimated_time='"+estimated_time+"'"
	    +"WHERE id='"+id+"'";
		int rst=stmt.executeUpdate(sql);
		if(rst>0) {
			isSuccess=true;
		}
		else {
			isSuccess=false;
		}
	}
	catch(Exception e) {
		e.printStackTrace();
	}
	return isSuccess;	
}

//Create function to Delete route details
public static boolean deleteRoute(int id) {
	try {
		//DB connection
		con=DBConnection.getConnection();
		stmt=con.createStatement();
		
		//SQL query
		String sql="DELETE FROM route WHERE id='"+id+"'";
		int rst=stmt.executeUpdate(sql);
		if(rst>0) {
			isSuccess=true;
		}
		else {
			isSuccess=false;
		}
	}
	catch(Exception e) {
		e.printStackTrace();
	}
	return isSuccess;	
}
}