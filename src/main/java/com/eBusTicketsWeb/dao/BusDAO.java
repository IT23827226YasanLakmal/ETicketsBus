package com.eBusTicketsWeb.dao;

import com.eBusTicketsWeb.model.Bus;
import java.sql.*;
import java.util.*;

public class BusDAO {
	 private final Connection connection;

	    public BusDAO(Connection connection) {
	        this.connection = connection;
	    }


 public List<Bus> getAllBusByScheduleId(int scheduleId) throws SQLException {
     List<Bus> buses = new ArrayList<>();
     String sql = """
     		SELECT *
     		FROM bus b
     		JOIN schedules s 
     		ON b.id = s.bus_id
     		WHERE s.id = ? ;
     		
     		""";
     try (PreparedStatement ps = connection.prepareStatement(sql)) {
    	 ps.setInt(1, scheduleId);
         ResultSet rs = ps.executeQuery();
         while (rs.next()) {
             buses.add(new Bus(
                 rs.getInt("id"),
                 rs.getString("bus_number"),
                 rs.getString("bus_type"),
                 rs.getInt("total_seats"),
                 rs.getInt("driver_id"),
                 rs.getInt("route_id")
             ));
         }
     }
     return buses;
 }

 
}
