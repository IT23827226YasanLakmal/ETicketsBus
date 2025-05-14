package com.eBusTicketsWeb.dao;

import com.eBusTicketsWeb.model.Route;
import com.eBusTicketsWeb.util.DBConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class RouteDao {
    private static boolean isSuccess;
    private static Connection con = null;
    private static Statement stmt = null;
    private static ResultSet rst = null;

// Insert new route details 
    public static int insertRoute(String start, String end, float distance_km) {
        int route_id = 0;
        try {
        	//DB connection
            con = DBConnection.getConnection();
            //SQL query to insert data
            String sql = "INSERT INTO route (start, end, distance_km) VALUES (?, ?, ?)";
            PreparedStatement stmt = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            stmt.setString(1, start);
            stmt.setString(2, end);
            stmt.setFloat(3, distance_km);
            //Execute the query
            int rows = stmt.executeUpdate();
            // Check if the insert was successful and retrieve the generated route ID
            if  (rows > 0) {
                rst= stmt.getGeneratedKeys();//Get generated route_id
                if (rst.next()) {
                    route_id = rst.getInt(1);
                }
            }
        } 
        catch (Exception e) {
            e.printStackTrace();
        }
        return route_id;
    }
    
//Display route details
    // Get a single route (by ID)
    public static Route getRouteById(int id) {
        Route route = null;
        try {
        	//DB connection
            con = DBConnection.getConnection();
            //SQL query for get data to display (by id)
            String sql = "SELECT * FROM route WHERE id = ?";
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setInt(1, id);
            //Execute the query
            ResultSet rst = stmt.executeQuery();
            // Check if a route was found
            if (rst.next()) {
                String start = rst.getString("start");
                String end = rst.getString("end");
                float distance_km = rst.getFloat("distance_km");
                route = new Route(id, start, end, distance_km);//retrieve data
            }
        } 
        catch (Exception e) {
            e.printStackTrace();
        }
        return route;
    }

    // Get all routes
    public static List<Route> getAllRoutes() {
        List<Route> routes = new ArrayList<>();
        try {
        	//DB connection
            con = DBConnection.getConnection();
            stmt = con.createStatement();
            //SQL query for get data to display (all)
            String sql = "SELECT * FROM route";
            rst = stmt.executeQuery(sql);
            //Take details of routes 
            while (rst.next()) {
                int id = rst.getInt("id");
                String start = rst.getString("start");
                String end = rst.getString("end");
                float distance_km = rst.getFloat("distance_km");
                Route route = new Route(id, start, end, distance_km);
                routes.add(route);//Add route details to the list
            }
        } 
        catch (Exception e) {
            e.printStackTrace();
        }
        return routes;
    }

// Update route details
    public static boolean updateRoute(int id, String start, String end, float distance_km) {
        boolean isSuccess = false;
        try {
        	//DB connection
            con = DBConnection.getConnection();
            //SQL query for update data
            String sql = "UPDATE route SET start = ?, end = ?, distance_km = ? WHERE id = ?";
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setString(1, start);
            stmt.setString(2, end);
            stmt.setFloat(3, distance_km);
            stmt.setInt(4, id);
            //Execute the query
            int rows = stmt.executeUpdate();
            isSuccess = (rows > 0);
        } 
        catch (Exception e) {
            e.printStackTrace();
        }
        return isSuccess;
    }

// Delete route
    public static boolean deleteRoute(int id) {
        boolean isSuccess = false;
        try {
        	//DB connection
            con = DBConnection.getConnection();
            //SQL query for delete route
            String sql = "DELETE FROM route WHERE id = ?";
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setInt(1, id);
            //Execute the query
            int rows = stmt.executeUpdate();
            isSuccess = (rows > 0);
        } 
        catch (Exception e) {
            e.printStackTrace();
        }
        return isSuccess;
    }
}
