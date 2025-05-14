package com.eBusTicketsWeb.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


@WebServlet("/staffLoginServlet")
public class staffLoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private static Connection con = null;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		 String email = request.getParameter("email");
	     String password = request.getParameter("password");
	     
	     try {
	    	 con = It23843370_DBconnection.getConnection();
	    	 String sql = "SELECT * FROM staff WHERE email=? AND password=?";
	            PreparedStatement stmt = con.prepareStatement(sql);
	            stmt.setString(1, email);
	            stmt.setString(2, password);
	            
	            
	            ResultSet rs = stmt.executeQuery();

	            if (rs.next()) {
	                String status = rs.getString("status");

	                HttpSession session = request.getSession();
	                session.setAttribute("staffName", rs.getString("name"));

	                if ("ADMIN".equals(status)) {
	                    response.sendRedirect("admin_dashboard.jsp");
	                } else if ("BUS_OPERATOR".equals(status)) {
	                    response.sendRedirect("bus_operator_dashboard.jsp");
	                } else {
	                    request.setAttribute("error", "Unknown role.");
	                    request.getRequestDispatcher("staffLogin.jsp").forward(request, response);
	                }
	            } else {
	                request.setAttribute("error", "Invalid email or password.");
	                request.getRequestDispatcher("staffLogin.jsp").forward(request, response);
	            }
	     }catch (SQLException e) {
	                throw new ServletException("DB Error", e);
	            }
	     
	}

}
