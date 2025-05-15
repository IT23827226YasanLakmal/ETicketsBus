package com.eBusTicketsWeb.controller;

import java.util.HashMap;
import java.util.Map;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

import com.eBusTicketsWeb.dao.RouteDao;
import com.eBusTicketsWeb.dao.RouteStopDao;
import com.eBusTicketsWeb.model.Route;
import com.eBusTicketsWeb.model.RouteStop;

@WebServlet("/RouteReadServlet")
public class RouteReadServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		List<Route> allRoutes = RouteDao.getAllRoutes();//Get all route records from the database
		Map<Integer, List <RouteStop>> routeStopsMap = new HashMap<>();//Create a map to hold each route and its list of stops
       
		//Get  stops for every route and add to the map
		for (Route route : allRoutes) {
		    List<RouteStop> stops = RouteStopDao.getStopsByRouteId(route.getId());
		    routeStopsMap.put(route.getId(), stops);
		}
		
		request.setAttribute("allRoutes", allRoutes);//Attach the list of routes 
		request.setAttribute("routeStopsMap", routeStopsMap);//Attach the map of stops 
		
		//Forward the attached details to RouteDetails.jsp for display the data
		RequestDispatcher dispatcher = request.getRequestDispatcher("RouteDetails.jsp");
		dispatcher.forward(request, response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		doGet(request,response);// Reuse doGet logic
	}

}
