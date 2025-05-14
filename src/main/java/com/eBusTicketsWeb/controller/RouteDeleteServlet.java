package com.eBusTicketsWeb.controller;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

import com.eBusTicketsWeb.dao.RouteDao;
import com.eBusTicketsWeb.dao.RouteStopDao;

@WebServlet("/RouteDeleteServlet")
public class RouteDeleteServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));

        // Delete stops of the route
        boolean stopsDeleted = RouteStopDao.deleteStopsByRouteId(id);

        // Delete the route details
        boolean routeDeleted = RouteDao.deleteRoute(id);

        // Show success or failure message and redirect
        if (stopsDeleted && routeDeleted) {
            String alertMessage = "Route and its stops deleted successfully.";
            response.getWriter().println("<script>alert('" + alertMessage + "'); window.location.href='RouteReadServlet';</script>");
        } else {
            String errorMessage = "Failed to delete route or its stops.";
            response.getWriter().println("<script>alert('" + errorMessage + "'); window.location.href='RouteReadServlet';</script>");
        }
    }
}

