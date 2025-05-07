package com.eBusTicketsWeb.service;

import com.eBusTicketsWeb.dao.ReservationDAO;
import com.eBusTicketsWeb.model.Reservation;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public class ReservationService {
    private ReservationDAO reservationDAO;

    public ReservationService(Connection connection) {
        this.reservationDAO = new ReservationDAO(connection);
    }

    public void bookReservation(Reservation reservation) throws SQLException {
        reservationDAO.insertReservation(reservation);
    }

    public List<Reservation> getAllReservations() throws SQLException {
    	return reservationDAO.getAllReservations().get();
    }
}
