package com.eBusTicketsWeb.dao;
import com.eBusTicketsWeb.model.Schedule;
import com.eBusTicketsWeb.model.ScheduleResult;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ScheduleDAO {
    private final Connection connection;

    public ScheduleDAO(Connection connection) {
        this.connection = connection;
    }

    public void addSchedule(Schedule schedule) throws SQLException {
        String sql = """
            INSERT INTO schedule (bus_id, route_id, driver_id, departure_time, arrival_time, travel_date, fare)
            VALUES (?, ?, ?, ?, ?, ?, ?)
        """;
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, schedule.getBusId());
            stmt.setInt(2, schedule.getRouteId());
            stmt.setInt(3, schedule.getDriverId());
            stmt.setTime(4, schedule.getDepartureTime());
            stmt.setTime(5, schedule.getArrivalTime());
            stmt.setDate(6, schedule.getTravelDate());
            stmt.executeUpdate();
        }
    }

    public List<ScheduleResult> getAllSchedules() throws SQLException {
    	List<ScheduleResult> list = new ArrayList<>();

        String sql = """
            SELECT 
            s.id,
        	s.arrival_time, 
        	s.departure_time,
        	s.travel_date,
        	r.start,
        	r.end
        	FROM schedule s
        	JOIN route r ON s.route_id = r.id
        	ORDER BY s.travel_date ASC;
        """;

        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            try (ResultSet rs = stmt.executeQuery()) {
                while (rs.next()) {
                    ScheduleResult result = new ScheduleResult();
                    result.setId(rs.getInt("id"));
                    result.setDepartureTime(rs.getTime("departure_time"));
                    result.setArrivalTime(rs.getTime("arrival_time"));
                    result.setTravelDate(rs.getDate("travel_date"));
                    result.setStart(rs.getString("start"));
                    result.setEnd(rs.getString("end"));
                    
                    list.add(result);
                }
            }
        }

        return list;
    }

    public List<ScheduleResult> getScheduleBySearch(String from, String to, String date) throws SQLException {
    	List<ScheduleResult> list = new ArrayList<>();

        String sql = """
            SELECT 
        	s.id,
        	s.departure_time,
        	s.arrival_time,
        	s.travel_date,
        	r.start,
        	r.end
        	FROM schedule s
        	JOIN route r ON s.route_id = r.id
        	JOIN route_stops rs_start ON r.id = rs_start.route_id OR rs_start.stop_name = ?
        	JOIN route_stops rs_end ON r.id = rs_end.route_id OR rs_end.stop_name = ?
        	WHERE s.travel_date = ?
        	AND rs_start.stop_order < rs_end.stop_order 
        	ORDER BY s.travel_date ASC;
        
        """;

        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setString(1, from);
            stmt.setString(2, to);
            stmt.setDate(3, Date.valueOf(date));

            try (ResultSet rs = stmt.executeQuery()) {
                while (rs.next()) {
                    ScheduleResult result = new ScheduleResult();
                    result.setId(rs.getInt("id"));
                    result.setDepartureTime(rs.getTime("departure_time"));
                    result.setArrivalTime(rs.getTime("arrival_time"));
                    result.setTravelDate(rs.getDate("travel_date"));
                    result.setStart(rs.getString("start"));
                    result.setEnd(rs.getString("end"));
                    
                    list.add(result);
                }
            }
        }

        return list;
    }

    public void deleteSchedule(int id) throws SQLException {
        String sql = "DELETE FROM schedule WHERE id = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, id);
            stmt.executeUpdate();
        }
    }

   
}