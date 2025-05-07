package com.eBusTicketsWeb.dao;
import com.eBusTicketsWeb.model.Schedule;

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
            stmt.setBigDecimal(7, schedule.getFare());
            stmt.executeUpdate();
        }
    }

    public List<Schedule> getAllSchedules() throws SQLException {
        String sql = "SELECT * FROM schedule";
        List<Schedule> schedules = new ArrayList<>();

        try (PreparedStatement stmt = connection.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {
            while (rs.next()) {
                schedules.add(mapResultSetToSchedule(rs));
            }
        }
        return schedules;
    }

    public Schedule getScheduleById(int id) throws SQLException {
        String sql = "SELECT * FROM schedule WHERE id = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, id);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    return mapResultSetToSchedule(rs);
                }
            }
        }
        return null;
    }

    public void deleteSchedule(int id) throws SQLException {
        String sql = "DELETE FROM schedule WHERE id = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, id);
            stmt.executeUpdate();
        }
    }

    private Schedule mapResultSetToSchedule(ResultSet rs) throws SQLException {
        return new Schedule(
            rs.getInt("id"),
            rs.getInt("bus_id"),
            rs.getInt("route_id"),
            rs.getInt("driver_id"),
            rs.getTime("departure_time"),
            rs.getTime("arrival_time"),
            rs.getDate("travel_date")
        );
    }
}