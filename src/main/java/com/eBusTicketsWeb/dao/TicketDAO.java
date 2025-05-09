package com.eBusTicketsWeb.dao;

import com.eBusTicketsWeb.model.Ticket;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class TicketDAO {
    private Connection connection;

    public TicketDAO(Connection connection) {
        this.connection = connection;
    }

    public void insertTicket(Ticket ticket) throws SQLException {
        String sql = "INSERT INTO ticket (user_id, schedule_id,bus_id, payment_id,booking_date, status) VALUES (?,?,?, ?, ?, ?)";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, ticket.getUserId());
            stmt.setInt(2, ticket.getScheduleId());
            stmt.setInt(3, ticket.getBusId());
            stmt.setInt(4, ticket.getPaymentId());
            stmt.setTimestamp(5, ticket.getBookingDate());
            stmt.setString(6, ticket.getStatus());
            stmt.executeUpdate();
        }
    }

    public Optional<List<Ticket>> getAllReservations() throws SQLException {
        List<Ticket> list = new ArrayList<>();
        String sql = "SELECT * FROM reservation";
        try (Statement stmt = connection.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                Ticket r = new Ticket();
                r.setId(rs.getInt("id"));
                r.setUserId(rs.getInt("user_id"));
                r.setScheduleId(rs.getInt("schedule_id"));
                r.setBusId(rs.getInt("bus_id"));
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
