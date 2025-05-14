package com.eBusTicketsWeb.controller;

import java.io.IOException;

import com.eBusTicketsWeb.dao.RouteDao;
import com.eBusTicketsWeb.dao.RouteStopDao;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/RouteInsertServlet")
public class RouteInsertServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	
    	// Get input data from the form
    	String start = request.getParameter("start");
        String end = request.getParameter("end");
        float distance_km = Float.parseFloat(request.getParameter("distance_km"));
        String[] stop_names = request.getParameterValues("stop_name");  // Get stop names from the form

        // Insert the route into the route table and get the route ID
        int route_id = RouteDao.insertRoute(start, end, distance_km);
        
        if (route_id > 0) {  // Check if the route was successfully inserted
            if (stop_names != null && stop_names.length > 0) { // Check if stop names were provided
                boolean allStopsInserted = true;
                for (int i = 0; i < stop_names.length; i++) {
                    String stop_name = stop_names[i].trim();
                    if (!stop_name.isEmpty()) {  // Check if stop name is not empty
                        int stop_order = i + 1;
                        // Insert each stop using the RouteStopDao
                        boolean inserted = RouteStopDao.insertRouteStop(route_id, stop_name, stop_order);  // Insert stop
                        if (!inserted) {
                            allStopsInserted = false;
                            break;
                        }
                    }
                }

                // Show success or failure message and redirect
                if (allStopsInserted) {
                    response.getWriter().println("<script>alert('Route and Stops Added Successfully'); window.location.href='RouteReadServlet';</script>");
                } 
                else {
                    response.getWriter().println("<script>alert('Route added, but some stops failed'); window.location.href='RouteReadServlet';</script>");
                }
                
            } 
            else {  // If no stops provided
                response.getWriter().println("<script>alert('No stop names provided'); window.location.href='RouteReadServlet';</script>");
            }
        } 
        else { // If route insertion failed
            response.getWriter().println("<script>alert('Failed to retrieve valid route ID to store Stop details'); window.location.href='RouteReadServlet';</script>");
        }
    }
}
