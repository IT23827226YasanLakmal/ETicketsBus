package com.eBusTicketsWeb.service;
import com.eBusTicketsWeb.dao.SeatDAO;
import com.eBusTicketsWeb.model.Seat;

import java.util.List;

public class SeatService {
    private SeatDAO seatDAO;

    
    public SeatService(SeatDAO seatDAO) {
		super();
		this.seatDAO = seatDAO;
	}


	public List<Seat> searchAllSeatsByBusId(int busId) {
        return seatDAO.getAllSeatsByBusId(busId);
    }
	
	public int reserveSeat(int seatId) {
        return seatDAO.setReserveSeat(seatId);
    }
}