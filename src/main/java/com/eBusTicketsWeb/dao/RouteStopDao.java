package com.eBusTicketsWeb.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.eBusTicketsWeb.model.Route;
import com.eBusTicketsWeb.model.RouteStop;
import com.eBusTicketsWeb.util.DBConnection;

public class RouteStopDao {
//Connect database
		private static boolean isSuccess;
		private static Connection con=null;
		private static Statement stmt=null;
		private static ResultSet rst=null;
		
//function to Tnsert new route stop details
		public static boolean insertRouteStop(int route_id, String stop_name, int stop_order) {
		    try{
		    	//DB connection
		        Connection conn = DBConnection.getConnection(); 
		       //SQL query to insert data
			   String sql = "INSERT INTO route_stop (route_id, stop_name, stop_order) VALUES (?, ?, ?)";
		       PreparedStatement stmt = conn.prepareStatement(sql);
		       stmt.setInt(1, route_id);
		       stmt.setString(2, stop_name);
		       stmt.setInt(3, stop_order);
		       //Execute and return
		       return stmt.executeUpdate() > 0;
		    } catch (Exception e) {
		        e.printStackTrace();
		    }
		    return false;
		}

//Create function to Display route stop details
    // Get a single route stop (by ID)
	public static RouteStop getRouteStopById (int Id){

		RouteStop routeStop=null;
		try {
			//DB connection
			con=DBConnection.getConnection();
			stmt=con.createStatement();
			//SQL query
			String sql = "SELECT id, route_id, stop_name, stop_order FROM route_stop WHERE route_id = " + Id + " ORDER BY stop_order";
		    //Execute the query
			rst =stmt.executeQuery(sql);
			//Set stop details
			if (rst.next()) {
			    int id = rst.getInt("id");
	            int route_id = rst.getInt("route_id");
	            String stop_name = rst.getString("stop_name");
	            int stop_order = rst.getInt("stop_order");
	            routeStop=new RouteStop(id,route_id,stop_name,stop_order);//retrieve data
	            }
	    }
		catch(Exception e) {
			e.printStackTrace();
		}
		return routeStop;	
	}

	//Get all route stop details
	public static List<RouteStop> getStopsByRouteId(int route_Id) {
	    ArrayList<RouteStop> routeStops = new ArrayList<>();
	    try {
	    	//DB connection
	        con = DBConnection.getConnection();
	        stmt = con.createStatement();
	       //SQL query for get data to display (all)
	        String sql = "SELECT * FROM route_stop WHERE route_id = " + route_Id + " ORDER BY stop_order";
	      //Execute the query
	        rst = stmt.executeQuery(sql);
	        //Take details of route stops
	        while (rst.next()) {
	            int id = rst.getInt("id");
	            int route_id = rst.getInt("route_id");
	            String stop_name = rst.getString("stop_name");
	            int stop_order = rst.getInt("stop_order");
	            RouteStop stop = new RouteStop(id, route_id, stop_name, stop_order);
	            routeStops.add(stop);//Add route details to the list
	        }
	    } 
	    catch (Exception e) {
	        e.printStackTrace();
	    }
	    return routeStops;
	}
	
// Update a route stop by ID and order
	public static boolean updateRouteStop(int id,int route_id, String stop_name, int stop_order){
		try {
			//DB connection
			con=DBConnection.getConnection();
			stmt=con.createStatement();
			//SQL query
			String sql="UPDATE route_stop SET id='"+id+"' route_id='"+route_id+"',stop_name='"+stop_name+"',stop_order='"+stop_order+"'"
		    +"WHERE id='"+id+"'";
			 //Execute the query
			int rows=stmt.executeUpdate(sql);
			if(rows>0) {
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
	
//Delete route stop
	public static boolean deleteStopsByRouteId(int route_Id) {
	    boolean isSuccess = false;
	    try {
	    	//DB connection
	    	con = DBConnection.getConnection();
	    	//SQL query for delete route stop
	        PreparedStatement ps = con.prepareStatement("DELETE FROM route_stop WHERE route_id = ?");
	        ps.setInt(1, route_Id);
	        //Execute the query
	        int rows = ps.executeUpdate();
	        isSuccess = true; // Even if 0 rows, it's not an error
	    } catch (Exception e) {
	        e.printStackTrace();
	    }
	    return isSuccess;
	}


}
