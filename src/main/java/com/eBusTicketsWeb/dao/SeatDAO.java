package com.eBusTicketsWeb.dao;

import com.eBusTicketsWeb.model.Seat;
import com.eBusTicketsWeb.util.DBConnection;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class SeatDAO {

	private final Connection connection;

    public SeatDAO(Connection connection) {
        this.connection = connection;
    }
    
    public List<Seat> getAllSeatsByBusId(int busId) {
        List<Seat> seats = new ArrayList<>();
        String query = "SELECT * FROM seat WHERE bus_id = ? AND seat.availability = 'NOT RESERVED'";

        try (
             PreparedStatement stmt = connection.prepareStatement(query)) {

            stmt.setInt(1, busId);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                Seat seat = new Seat();
                seat.setId(rs.getInt("id"));
                seat.setBusId(rs.getInt("bus_id"));
                seat.setSeatNumber(rs.getString("seat_number"));
                seat.setSeatType(rs.getString("seat_type"));
                seat.setAvailability(rs.getString("availability"));

                seats.add(seat);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return seats;
    }
    
    public int setReserveSeat(int seatId) {
    	
    	String query = "UPDATE seat SET seat.availability = 'RESERVED' WHERE seat.id = ?";
    	
    	try (
    		PreparedStatement stmt = connection.prepareStatement(query)) {
    		
    		stmt.setInt(1, seatId);
    		
    		return stmt.executeUpdate();
    		
    	}catch (SQLException e) {
            e.printStackTrace();
        }
    	return 0;

    }
}
