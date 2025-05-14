package com.eBusTicketsWeb.controller;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;


@WebServlet("/getallSchedule")
public class It23843370_getallSchedule extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		
		List <It23843370_scheduleModel> allSchedules = It23843370_scheduleControl.getallSchedules();
		request.setAttribute("allSchedules",allSchedules);
		
		List<It23843370_busModel> allbusIds = It23843370_scheduleControl.getAllBusIds();
		request.setAttribute("allbusIds",allbusIds);
		
		List<It23843370_routeModel> allrouteIds = It23843370_scheduleControl.getAllRouteIds();
		request.setAttribute("allrouteIds",allrouteIds);
		
		List<It23843370_driverModel> alldriverIds = It23843370_scheduleControl.getAllDriverIds();
		request.setAttribute("alldriverIds",alldriverIds);

		
		RequestDispatcher dispatcher = request.getRequestDispatcher("bus_operator_dashboard.jsp");
		dispatcher.forward(request, response);
	}
	
protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request,response);
	}

}
