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

@WebServlet("/RouteReadServlet")
public class RouteReadServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List <Route> allRoutes= RouteDao.getAllRoutes();
		request.setAttribute("allRoutes", allRoutes);
		
		RequestDispatcher dispatcher= request.getRequestDispatcher("RouteDetails.jsp");
		dispatcher.forward(request, response);
		
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		doGet(request,response);
	}

}
