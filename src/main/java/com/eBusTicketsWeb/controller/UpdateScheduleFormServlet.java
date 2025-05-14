package com.eBusTicketsWeb.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;


@WebServlet("/UpdateScheduleFormServlet")
public class UpdateScheduleFormServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// Get current values from query params
        request.setAttribute("id", request.getParameter("id"));
        request.setAttribute("bus", request.getParameter("bus"));
        request.setAttribute("route", request.getParameter("route"));
        request.setAttribute("driver", request.getParameter("driver"));
        request.setAttribute("departure", request.getParameter("departure"));
        request.setAttribute("arrival", request.getParameter("arrival"));
        request.setAttribute("date", request.getParameter("date"));

        // Get data for dropdowns
        request.setAttribute("allbusIds", It23843370_scheduleControl.getAllBusIds());
        request.setAttribute("allrouteIds", It23843370_scheduleControl.getAllRouteIds());
        request.setAttribute("alldriverIds", It23843370_scheduleControl.getAllDriverIds());

        // Forward to JSP
        request.getRequestDispatcher("updateSchedule.jsp").forward(request, response);
	}

	
	

}
