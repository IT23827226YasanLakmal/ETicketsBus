package com.eBusTicketsWeb.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.eBusTicketsWeb.dao.BusDAO;
import com.eBusTicketsWeb.dao.SeatDAO;
import com.eBusTicketsWeb.dao.UserDAO;
import com.eBusTicketsWeb.model.Bus;
import com.eBusTicketsWeb.model.RegisterRequest;
import com.eBusTicketsWeb.model.ScheduleResult;
import com.eBusTicketsWeb.model.Seat;
import com.eBusTicketsWeb.service.ScheduleService;
import com.eBusTicketsWeb.service.SeatService;
import com.eBusTicketsWeb.service.UserService;
import com.eBusTicketsWeb.util.DBConnection;
import com.eBusTicketsWeb.service.BusService;

@WebServlet(urlPatterns = {
	    "/user/register",
	    "/user/login",
	    "/user/logout",
	    "/user/searchTicket",
	    "/user/viewAllBus",
	    "/user/viewAllBus/seat",
	    "/user/viewAllBus/seat/book",
	    "/user/home"
	    
	})
	public class UserServlet extends HttpServlet {
	
	 @Override
	    protected void doGet(HttpServletRequest request, HttpServletResponse response)
	            throws ServletException, IOException {
	        String path = request.getServletPath();

	        switch (path) {
	            case "/user/home":
	            	fetchAllSchedules(request, response);
	            	break;
	            case "/user/logout":
	                handleLogout(request, response);
	                break;
	        }
	    }
	 
	 	@Override
	    protected void doPost(HttpServletRequest request, HttpServletResponse response)
	            throws ServletException, IOException {
	        String path = request.getServletPath();

	        switch (path) {
	            case "/user/register":
	                handleRegister(request, response);
	                break;
	            case "/user/login":
	                handleLogin(request, response);
	                break;
	            case "/user/searchTicket":
	                handleSearch(request, response);
	                break;
	            case "/user/viewAllBus":
	                handleViewAllBus(request, response);
	                break;
	            case "/user/viewAllBus/seat":
	                handleViewSeat(request, response);
	                break; 
	            case "/user/viewAllBus/seat/book":
	            	handleBookTicket(request, response);
	                break;
	            case "/user/bookingHistory":
	                handleBookingHistory(request, response);
	                break;
	            default:
	                response.sendError(HttpServletResponse.SC_NOT_FOUND);
	        }
	    }

		private void fetchAllSchedules(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
			 HttpSession session = request.getSession(false);

			 if (session == null || session.getAttribute("username") == null) {
			     response.sendRedirect(request.getContextPath() + "/user_login.jsp");
			     return;
			}
	 		ScheduleService scheduleService = new ScheduleService(DBConnection.getConnection());
	 		List<ScheduleResult> scheduleList;
			try {
				scheduleList = scheduleService.fetchAllSchedules();
				request.setAttribute("scheduleList", scheduleList);
				request.getRequestDispatcher("/user_home.jsp").forward(request, response);
			} 
			
			catch (ServletException e) {
				
				e.printStackTrace();
			}
	        catch (SQLException e) {
				
				e.printStackTrace();
			} catch (IOException e) {
	
				e.printStackTrace();
			}
	 	}
	    private void handleRegister(HttpServletRequest request, HttpServletResponse response) throws ServletException {

	        RegisterRequest registerRequest = new RegisterRequest();
	        registerRequest.setUsername(request.getParameter("username"));
	        registerRequest.setEmail(request.getParameter("email"));
	        registerRequest.setPassword(request.getParameter("password"));
	        registerRequest.setConfirmPassword(request.getParameter("confirmPassword"));
	        registerRequest.setPhone(request.getParameter("phone"));
	        

	        try {
	            UserService userService = new UserService(new UserDAO(DBConnection.getConnection()));
//	            List<String> errors = userService.validateRegistration(registerRequest);
	//
//	            if (!errors.isEmpty()) {
//	                request.setAttribute("errors", errors);
//	                request.getRequestDispatcher("register.jsp").forward(request, response);
//	                return;
//	            }

	            boolean registered = userService.register(
	                    registerRequest.getUsername(),
	                    registerRequest.getEmail(),
	                    registerRequest.getPassword(),
	                    registerRequest.getPhone()
	            );
	            
	            if (registered) {
	                response.sendRedirect("/eBusTicketsWeb/user_login.jsp");
	            } else {
	                request.setAttribute("error", "Username already taken.");
	                request.getRequestDispatcher("/eBusTicketsWeb/user_register.jsp").forward(request, response);
	            }

	        } catch (Exception e) {
	            throw new ServletException("Registration failed", e);
	        }
	    }

	    private void handleLogin(HttpServletRequest request, HttpServletResponse response) throws IOException {
	    	String username = request.getParameter("username");
	    	String password = request.getParameter("password");

	    	try {
	    		UserService userService = new UserService(new UserDAO(DBConnection.getConnection()));
	    		boolean authenticated = userService.authenticate(username, password);
	    		
	    		if(authenticated) {
	    			HttpSession session = request.getSession();
	    			session.setAttribute("username", username);
	    			response.sendRedirect("home");

	    		}else {
	    			request.setAttribute("error","Invalid username or password.");
	    			request.getRequestDispatcher("/eBusTicketsWeb/user_login.jsp").forward(request, response);
	    		}
	    	}catch(Exception e) {
	    		throw new IOException(e);
	    	}
	    }
	    
	    private void handleLogout(HttpServletRequest request, HttpServletResponse response) throws IOException {
	        HttpSession session = request.getSession(false); // don't create if not exists
	        if (session != null) {
	            session.invalidate();
	        }
	        response.sendRedirect(request.getContextPath() + "/user_login.jsp");
	    }


	    private void handleSearch(HttpServletRequest request, HttpServletResponse response) throws ServletException {
	    	String from = request.getParameter("from");
	        String to = request.getParameter("to");
	        String date = request.getParameter("date");

	        try {
	            ScheduleService scheduleService = new ScheduleService(DBConnection.getConnection());
	            List<ScheduleResult> scheduleList = scheduleService.getScheduleBySearch(from, to, date);

	            
	            request.setAttribute("scheduleList", scheduleList);
				request.getRequestDispatcher("/user_home.jsp").forward(request, response);
	            
	        } catch (Exception e) {
	            throw new ServletException("Error searching for tickets", e);
	        }
	    }

	    private void handleViewAllBus(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
	        // Update logic
	    	int id = Integer.parseInt(request.getParameter("scheduleId"));
	    	String travelDate = request.getParameter("travelDate");
	    	String departureTime = request.getParameter("departureTime");
	    	String arrivalTime = request.getParameter("arrivalTime");
	    	
	    	HttpSession session = request.getSession();
			session.setAttribute("scheduleId", id);
			session.setAttribute("travelDate", travelDate);
			session.setAttribute("departureTime", departureTime);
			session.setAttribute("arrivalTime", arrivalTime);
			
	    	try {
	            BusService busService = new BusService(new BusDAO(DBConnection.getConnection()));
	            List<Bus> busList = busService.searchAllBusByScheduleId(id);

	            
	            request.setAttribute("busList", busList);
	            
				request.getRequestDispatcher("/user_bus_result.jsp").forward(request, response);
	            
	        } catch (Exception e) {
	            throw new ServletException("Error searching for tickets", e);
	        }
	       
	    }
	    
	    
	    private void handleViewSeat(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
	    	
	    	HttpSession session = request.getSession();
	        int userId = 1;
	        int scheduleId = (int) session.getAttribute("scheduleId");
	    	String travelDate = (String) session.getAttribute("travelDate");
	    	String arrivalTime = (String) session.getAttribute("arrivalTime");
	    	String departureTime = (String) session.getAttribute("departureTime");
	    	
	    	int busId = Integer.parseInt(request.getParameter("busId"));
	    	String busType = request.getParameter("busType");
	    	String busNumber = request.getParameter("busNumber");
	    
	    	
	    	try {
	            SeatService seatService = new SeatService(new SeatDAO(DBConnection.getConnection()));
	            List<Seat> seatList = seatService.searchAllSeatsByBusId(busId);

	            
	            request.setAttribute("seatList", seatList);
	            request.setAttribute("scheduleId", scheduleId);
	            request.setAttribute("travelDate", travelDate);
	            request.setAttribute("arrivalTime", arrivalTime);
	            request.setAttribute("departureTime", departureTime);
	            request.setAttribute("busId", busId);
	            request.setAttribute("busType", busType);
	            request.setAttribute("busNumber", busNumber);
	           
	            
				request.getRequestDispatcher("/user_seat_result.jsp").forward(request, response);
	            
	        } catch (Exception e) {
	            throw new ServletException("Error searching for tickets", e);
	        }
	    	
	        
	    }
	    
	    private void handleBookTicket(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		       
	    	
	        String selectedSeatsParam = request.getParameter("selectedSeats");

	        if (selectedSeatsParam != null && !selectedSeatsParam.isEmpty()) {
	           
	            String[] seatIdsArray = selectedSeatsParam.split(",");

	            SeatService seatService = new SeatService(new SeatDAO(DBConnection.getConnection()));
	            
	            List<Integer> seatIds = new ArrayList<>();
	            for (String idStr : seatIdsArray) {
	                seatIds.add(Integer.parseInt(idStr.trim()));
	            }

	      
	            for (int seatId : seatIds) {
	            	seatService.reserveSeat(seatId);
	            }
	          
	            request.setAttribute("totalPrice", 400.00);
	            request.getRequestDispatcher("/user_payment.jsp").forward(request, response);
	            
	        } else {
	          
	            request.setAttribute("errorMessage", "Please select at least one seat.");
	            request.getRequestDispatcher("/user_bus_result.jsp").forward(request, response);
	        }
	    }
	    
	    private void handleBookingHistory(HttpServletRequest request, HttpServletResponse response) throws IOException {
	       
	   
	    }
	}