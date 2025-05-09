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

@WebServlet("/RouteDeleteServlet")
public class RouteDeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		boolean isTrue;
		isTrue=RouteDao.deleteRoute(id);
		if(isTrue== true) {
			String alertMessage="Route Details Succcessfully Deleted.";
			response.getWriter().println("<script>alert('"+alertMessage+"');"+"window.location.href='RouteReadServlet';</script>");
		}
		else {
			List<Route> routeDetails= RouteDao.getById(id);
			request.setAttribute("routeDetails",routeDetails);
			
			RequestDispatcher dis= request.getRequestDispatcher("wrong.jsp");
			dis.forward(request, response);
		}
	}
}
