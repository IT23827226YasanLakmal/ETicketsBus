package com.eBusTicketsWeb.controller;

import java.io.IOException;

import com.eBusTicketsWeb.dao.UserDAO;
import com.eBusTicketsWeb.service.UserService;
import com.eBusTicketsWeb.util.DBConnection;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

    	String username = request.getParameter("username");
    	String password = request.getParameter("password");

    	try {
    		UserService userService = new UserService(new UserDAO(DBConnection.getConnection()));
    		boolean authenticated = userService.authenticate(username, password);
    		
    		if(authenticated) {
    			HttpSession session = request.getSession();
    			session.setAttribute("username", username);
    			response.sendRedirect("/user/user_dashboard.jsp");

    		}else {
    			request.setAttribute("error","Invalid username or password.");
    			request.getRequestDispatcher("login.jsp").forward(request, response);
    		}
    	}catch(Exception e) {
    		throw new ServletException(e);
    	}
    }
}
