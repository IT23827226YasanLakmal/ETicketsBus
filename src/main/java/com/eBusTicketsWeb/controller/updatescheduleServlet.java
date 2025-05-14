package com.eBusTicketsWeb.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;


@WebServlet("/updatescheduleServlet")
public class updatescheduleServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int id = Integer.parseInt(request.getParameter("scheduleId"));
        int busId = Integer.parseInt(request.getParameter("busId"));
        int routeId = Integer.parseInt(request.getParameter("routeId"));
        int driverId = Integer.parseInt(request.getParameter("driverId"));
        String depStr = request.getParameter("departureTime");
        String arrStr = request.getParameter("arrivalTime");
        String dateStr = request.getParameter("travelDate");
        //double fare = Double.parseDouble(request.getParameter("fare"));
        
        // No custom formatters needed
        LocalTime departure = LocalTime.parse(depStr);          // expects HH:mm
        LocalTime arrival = LocalTime.parse(arrStr);            // expects HH:mm
        LocalDate travelDate = LocalDate.parse(dateStr);        // expects yyyy-MM-dd
        
        boolean isTrue;
        
        isTrue = It23843370_scheduleControl.updatedata(id, busId, routeId, driverId, depStr, arrStr, dateStr);
        
        if(isTrue == true) {
        	
        	String ID = String.valueOf(id);
        	List<It23843370_scheduleModel> schedules = It23843370_scheduleControl.getById(ID);
        	request.setAttribute("schedules", schedules);
        	String alertmsg = "Data updated successfully";
        	response.getWriter().println("<script> alert('"+alertmsg+"');window.location.href='getallSchedule'</script>");
        }
        else {
        	
        	/*RequestDispatcher dis2 = request.getRequestDispatcher("wrong.jsp");
        	dis2.forward(request, response);*/
        	
        	System.out.println("Insert status: " + isTrue);

        }
	}

}
