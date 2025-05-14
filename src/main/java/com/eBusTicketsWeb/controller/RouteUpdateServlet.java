package com.eBusTicketsWeb.controller;

import java.io.IOException;
import java.util.List;

import com.eBusTicketsWeb.dao.RouteDao;
import com.eBusTicketsWeb.dao.RouteStopDao;
import com.eBusTicketsWeb.model.Route;
import com.eBusTicketsWeb.model.RouteStop;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/RouteUpdateServlet")
public class RouteUpdateServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        
    	String routeIdStr = request.getParameter("route_id"); // Get route_id from form
        
        // Check if route_id is missing
        if (routeIdStr == null || routeIdStr.isEmpty()) {
            response.getWriter().println("<script>alert('Missing route ID'); window.location.href='RouteReadServlet';</script>");
            return;
        }
        try {
            int route_id = Integer.parseInt(routeIdStr);// Convert route_id from string to integer

            // Get route and stop details from the database using RouteDao and RouteStopDao
            Route route = RouteDao.getRouteById(route_id);
            List<RouteStop> stops = RouteStopDao.getStopsByRouteId(route_id);

            if (route == null) {//Check if the route exists
                response.getWriter().println("<script>alert('Route not found'); window.location.href='RouteReadServlet';</script>");
            } else { // Attach route and stops and forward to JSP form for editing
                request.setAttribute("route", route);
                request.setAttribute("stops", stops);
                request.getRequestDispatcher("RouteUpdate.jsp").forward(request, response);
            }
        } catch (NumberFormatException e) {
            response.getWriter().println("<script>alert('Invalid route ID format'); window.location.href='RouteReadServlet';</script>");
        }
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Retrieve updated data from form
        String start = request.getParameter("start");
        String end = request.getParameter("end");
        float distance_km = Float.parseFloat(request.getParameter("distance_km"));
        String[] stop_names = request.getParameterValues("stop_name");
        int route_id = Integer.parseInt(request.getParameter("route_id"));
        
        try {
            // Update the route details first
            boolean updatedRoute = RouteDao.updateRoute(route_id, start, end, distance_km);
            
            if (!updatedRoute) {
                response.getWriter().println("<script>alert('Failed to update route'); window.location.href='RouteReadServlet';</script>");
                return;
            }
            
            RouteStopDao.deleteStopsByRouteId(route_id);
            
            // Get stop orders from form
            String[] stop_orders = request.getParameterValues("stop_order");
            
           
           // Handle case when no stops are provided
            if (stop_orders == null || stop_orders.length == 0 || stop_names == null || stop_names.length == 0) {
                // Insert "No stops" with order 0
                boolean inserted = RouteStopDao.insertRouteStop(route_id, "No stops", 0);
                if (inserted) {
                    response.getWriter().println("<script>alert('Route updated with no stops'); window.location.href='RouteReadServlet';</script>");
                } else {
                    response.getWriter().println("<script>alert('Route updated but failed to set no stops'); window.location.href='RouteReadServlet';</script>");
                }
                return;
            }
            
            // Convert stop orders to integers
            int[] orders = new int[stop_orders.length];
            for (int i = 0; i < stop_orders.length; i++) {
                orders[i] = Integer.parseInt(stop_orders[i].trim());
            }
            
            // Check for duplicates
            for (int i = 0; i < orders.length; i++) {
                for (int j = i + 1; j < orders.length; j++) {
                    if (orders[i] == orders[j]) {
                        response.getWriter().println("<script>alert('Duplicate stop order: " + orders[i] + "'); window.history.back();</script>");
                        return;
                    }
                }
            }
            
            // Check if orders start from 1 and are sequential
            int minOrder = orders[0];
            for (int order : orders) {
                if (order < minOrder) {
                    minOrder = order;
                }
            }
            
            // Should start from 1
            if (minOrder != 1) {
                response.getWriter().println("<script>alert('First stop order must be 1'); window.history.back();</script>");
                return;
            }
            
            // Check if all numbers from 1 to max exist
            int maxOrder = orders[0];
            for (int order : orders) {
                if (order > maxOrder) {
                    maxOrder = order;
                }
            }
            
            // Verify all numbers between 1 and maxOrder exist
            for (int i = 1; i <= maxOrder; i++) {
                boolean found = false;
                for (int order : orders) {
                    if (order == i) {
                        found = true;
                        break;
                    }
                }
                if (!found) {
                    response.getWriter().println("<script>alert('Missing stop order: " + i + "'); window.history.back();</script>");
                    return;
                }
            }
            
            // Delete existing stops before inserting new ones
            RouteStopDao.deleteStopsByRouteId(route_id);
            
            boolean allStopsInserted = true;
            
            // Insert stops
            for (int i = 0; i < stop_names.length; i++) {
                String stop_name = stop_names[i].trim();
                int stop_order = orders[i];
                
                if (!stop_name.isEmpty()) {
                    boolean inserted = RouteStopDao.insertRouteStop(route_id, stop_name, stop_order);
                    if (!inserted) {
                        allStopsInserted = false;
                        break;
                    }
                }
            }
            
            // Return appropriate response
            if (allStopsInserted) {
                response.getWriter().println("<script>alert('Route and stops updated successfully'); window.location.href='RouteReadServlet';</script>");
            } else {
                response.getWriter().println("<script>alert('Route updated but some stops failed'); window.location.href='RouteReadServlet';</script>");
            }
            
        } catch (NumberFormatException e) {
            response.getWriter().println("<script>alert('Invalid number in stop orders'); window.history.back();</script>");
        } catch (Exception e) {
            response.getWriter().println("<script>alert('Error: " + e.getMessage() + "'); window.history.back();</script>");
        }
    }
}