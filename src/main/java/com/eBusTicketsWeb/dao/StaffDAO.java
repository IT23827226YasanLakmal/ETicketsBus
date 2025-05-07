package com.eBusTicketsWeb.dao;

import com.eBusTicketsWeb.model.Staff;
import java.sql.PreparedStatement;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.ResultSet;

public class StaffDAO {
	private Connection connection;
	
	public StaffDAO(Connection connection) {
		this.connection = connection;
	}

	public void addStaff(Staff staff) throws SQLException {
		String sql = "INSERT INTO staff (name, email, password_hash, phone, role) VALUES (?,?,?,?,?)";
		try(PreparedStatement stmt = connection.prepareStatement(sql)){
			stmt.setString(1, staff.getName());
			stmt.setString(2, staff.getEmail());
			stmt.setString(3, staff.getPassword());
	        stmt.setString(4, staff.getPhone());
	        stmt.setString(5, staff.getRole());
	        stmt.executeUpdate();
		}
	}
	
	public Staff getStaffByEmail(String email) throws SQLException{
		String sql = "SELECT * FROM staff WHERE email = ?";
		try(PreparedStatement stmt = connection.prepareStatement(sql)){
			stmt.setString(1, email);
			ResultSet rs = stmt.executeQuery();
			
			if(rs.next()) {
				return mapResultSetToStaff(rs);
			}
		}
		return null;
	}
	
	public Staff mapResultSetToStaff(ResultSet rs) throws SQLException {
		return new Staff(
				rs.getInt("id"),
				rs.getString("name"),
				rs.getString("email"),
				rs.getString("password_hash"),
				rs.getString("phone"),
				rs.getString("role"),
				rs.getTimestamp("created_at"));
		
	}

}
