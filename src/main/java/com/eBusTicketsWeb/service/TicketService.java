package com.eBusTicketsWeb.service;

import com.eBusTicketsWeb.dao.TicketDAO;
import com.eBusTicketsWeb.model.Ticket;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public class TicketService {
    private TicketDAO ticketDAO;

    public TicketService(Connection connection) {
        this.ticketDAO = new TicketDAO(connection);
    }

    public void bookTicket(Ticket ticket) throws SQLException {
    	ticketDAO.insertReservation(ticket);
    }

    public List<Ticket> getAllTickets() throws SQLException {
    	return ticketDAO.getAllReservations().get();
    }
}
