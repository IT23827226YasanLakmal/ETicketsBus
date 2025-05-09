package com.eBusTicketsWeb.controller;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

import com.eBusTicketsWeb.dao.RouteDao;
import com.eBusTicketsWeb.model.Route;

@WebServlet("/RouteUpdateServlet")
public class RouteUpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int hh = Integer.parseInt(request.getParameter("hh"));
		int mm = Integer.parseInt(request.getParameter("mm"));
		int ss = Integer.parseInt(request.getParameter("ss"));

		int id = Integer.parseInt(request.getParameter("id"));
		String source= request.getParameter("source");
		String destination= request.getParameter("destination");
		float distance_km = Float.parseFloat(request.getParameter("distance_km"));
		String stops= request.getParameter("stops");
		String estimated_time = String.format("%02d:%02d:%02d", hh, mm, ss);
		
		boolean isTrue;
		isTrue= RouteDao.updateDetails(id,source, destination, distance_km, stops, estimated_time);
		
		if(isTrue==true) {
			List<Route> routeDetails= RouteDao.getById(id);
			request.setAttribute("routeDetails",routeDetails);
			
			String altermessage= "Route Details Successfully Updated.";
			response.getWriter().println("<script> alert('"+altermessage+"'); window.location.href='RouteReadServlet'</script>");
		}
		else {
			RequestDispatcher dis= request.getRequestDispatcher("wrong.jsp");
			dis.forward(request, response);
		}
		
	}

}
