package com.eBusTicketsWeb.controller;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;


@WebServlet("/deleteScheduleServlet")
public class deleteScheduleServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String id = request.getParameter("scheduleId");
		boolean isTrue;
		isTrue = It23843370_scheduleControl.deletedata(id);
		if(isTrue == true) {
			
			String alertMessage = "Record deleted successfully";
			response.getWriter().println("<script>alert('"+alertMessage+"');"+"window.location.href='getallSchedule';</script>");
		}
		else {
			List <It23843370_scheduleModel> allSchedules = It23843370_scheduleControl.getById(id);
			request.setAttribute("allSchedules",allSchedules);
			
			RequestDispatcher dispatcher = request.getRequestDispatcher("bus_operator_dashboard.jsp");
			dispatcher.forward(request, response);
			
		}
		
	}

}
