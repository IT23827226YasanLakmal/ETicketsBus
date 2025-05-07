package com.eBusTicketsWeb.dao;

import com.eBusTicketsWeb.model.Reservation;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class ReservationDAO {
    private Connection connection;

    public ReservationDAO(Connection connection) {
        this.connection = connection;
    }

    public void insertReservation(Reservation reservation) throws SQLException {
        String sql = "INSERT INTO reservation (user_id, schedule_id, seat_id, payment_id, status) VALUES (?, ?, ?, ?, ?)";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, reservation.getUserId());
            stmt.setInt(2, reservation.getScheduleId());
            stmt.setInt(3, reservation.getSeatId());
            stmt.setInt(4, reservation.getPaymentId());
            stmt.setString(5, reservation.getStatus());
            stmt.executeUpdate();
        }
    }

    public Optional<List<Reservation>> getAllReservations() throws SQLException {
        List<Reservation> list = new ArrayList<>();
        String sql = "SELECT * FROM reservation";
        try (Statement stmt = connection.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                Reservation r = new Reservation();
                r.setId(rs.getInt("id"));
                r.setUserId(rs.getInt("user_id"));
                r.setScheduleId(rs.getInt("schedule_id"));
                r.setSeatId(rs.getInt("seat_id"));
                r.setPaymentId(rs.getInt("payment_id"));
                r.setBookingDate(rs.getTimestamp("booking_date"));
                r.setStatus(rs.getString("status"));
                list.add(r);
            }
            if(!list.isEmpty()) {
                return Optional.of(list);
            }
        }
        return Optional.empty();
    }
}
