package com.eBusTicketsWeb.service;

import com.eBusTicketsWeb.dao.TicketDAO;
import com.eBusTicketsWeb.model.Ticket;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public class TicketService {
    private TicketDAO ticketDAO;

    public TicketService(TicketDAO ticketDAO) {
        this.ticketDAO = ticketDAO;
    }

    public void bookTicket(Ticket ticket) throws SQLException {
    	ticketDAO.insertTicket(ticket);
    }

    public List<Ticket> getAllTickets() throws SQLException {
    	return ticketDAO.getAllReservations().get();
    }
}
