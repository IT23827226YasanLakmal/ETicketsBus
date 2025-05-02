package com.eBusTicketsWeb.controller;

import java.io.IOException;
import java.util.List;

import com.eBusTicketsWeb.dao.UserDAO;
import com.eBusTicketsWeb.model.RegisterRequest;
import com.eBusTicketsWeb.service.UserService;
import com.eBusTicketsWeb.util.DBConnection;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/register")
public class RegisterServlet extends HttpServlet {
	
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        RegisterRequest registerRequest = new RegisterRequest();
        registerRequest.setUsername(request.getParameter("username"));
        registerRequest.setEmail(request.getParameter("email"));
        registerRequest.setPassword(request.getParameter("password"));
        registerRequest.setConfirmPassword(request.getParameter("confirmPassword"));
        

        try {
            UserService userService = new UserService(new UserDAO(DBConnection.getConnection()));
//            List<String> errors = userService.validateRegistration(registerRequest);
//
//            if (!errors.isEmpty()) {
//                request.setAttribute("errors", errors);
//                request.getRequestDispatcher("register.jsp").forward(request, response);
//                return;
//            }

            boolean registered = userService.register(
                    registerRequest.getUsername(),
                    registerRequest.getEmail(),
                    registerRequest.getPassword()
            );
            
            if (registered) {
                response.sendRedirect("login.jsp");
            } else {
                request.setAttribute("error", "Username already taken.");
                request.getRequestDispatcher("register.jsp").forward(request, response);
            }

        } catch (Exception e) {
            throw new ServletException("Registration failed", e);
        }
    }
}
