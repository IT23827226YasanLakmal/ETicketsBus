package com.eBusTicketsWeb.dao;

import com.eBusTicketsWeb.model.Payment;
import com.eBusTicketsWeb.util.DBConnection;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class PaymentDAO {
	
	private Connection connection;
	
	public PaymentDAO(Connection connection) {
		this.connection = connection;
	}

	public int insertPayment(Payment payment) throws SQLException {
	    String sql = "INSERT INTO payment (user_id, amount, payment_method, payment_status) VALUES (?, ?, ?, ?)";
	    try (PreparedStatement stmt = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
	        stmt.setInt(1, payment.getUserId());
	        stmt.setDouble(2, payment.getAmount());
	        stmt.setString(3, payment.getPaymentMethod());
	        stmt.setString(4, payment.getPaymentStatus());

	        int affectedRows = stmt.executeUpdate();

	        if (affectedRows == 0) {
	            throw new SQLException("Creating payment failed, no rows affected.");
	        }

	        try (ResultSet generatedKeys = stmt.getGeneratedKeys()) {
	            if (generatedKeys.next()) {
	                return generatedKeys.getInt(1);  // Just return the payment id
	            } else {
	                throw new SQLException("Creating payment failed, no ID obtained.");
	            }
	        }
	    }
	}



    public List<Payment> getAllPayments() throws SQLException {
        List<Payment> payments = new ArrayList<>();
        String sql = "SELECT * FROM payment";
        try (Connection conn = DBConnection.getConnection(); Statement stmt = conn.createStatement(); ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                Payment p = extractPayment(rs);
                payments.add(p);
            }
        }
        return payments;
    }

    public Payment getPaymentById(int id) throws SQLException {
        String sql = "SELECT * FROM payment WHERE id = ?";
        try (Connection conn = DBConnection.getConnection(); PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, id);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    return extractPayment(rs);
                }
            }
        }
        return null;
    }

    public void updatePayment(Payment payment) throws SQLException {
        String sql = "UPDATE payment SET user_id=?, amount=?, payment_method=?, payment_status=? WHERE id=?";
        try (Connection conn = DBConnection.getConnection(); PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, payment.getUserId());
            stmt.setDouble(2, payment.getAmount());
            stmt.setString(3, payment.getPaymentMethod());
            stmt.setString(4, payment.getPaymentStatus());
            stmt.setInt(5, payment.getId());
            stmt.executeUpdate();
        }
    }

    public void deletePayment(int id) throws SQLException {
        String sql = "DELETE FROM payment WHERE id=?";
        try (Connection conn = DBConnection.getConnection(); PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, id);
            stmt.executeUpdate();
        }
    }

    private Payment extractPayment(ResultSet rs) throws SQLException {
        Payment p = new Payment();
        p.setId(rs.getInt("id"));
        p.setUserId(rs.getInt("user_id"));
        p.setAmount(rs.getDouble("amount"));
        p.setPaymentMethod(rs.getString("payment_method"));
        p.setPaymentStatus(rs.getString("payment_status"));
        p.setPaymentDate(rs.getTimestamp("payment_date"));
        p.setUpdatedAt(rs.getTimestamp("updated_at"));
        return p;
    }
}
