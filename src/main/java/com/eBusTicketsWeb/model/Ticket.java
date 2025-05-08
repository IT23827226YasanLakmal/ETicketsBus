package com.eBusTicketsWeb.model;

import java.sql.Timestamp;

public class Ticket {
    private int id;
    private int userId;
    private int scheduleId;
    private int seatId;
    private int paymentId;
    private Timestamp bookingDate;
    private String status;
    

    public Ticket(){
    	
    }
    public Ticket(int id, int userId, int scheduleId, int seatId, int paymentId, Timestamp bookingDate, String status) {
		super();
		this.id = id;
		this.userId = userId;
		this.scheduleId = scheduleId;
		this.seatId = seatId;
		this.paymentId = paymentId;
		this.bookingDate = bookingDate;
		this.status = status;
	}
	// Getters and Setters
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public int getUserId() { return userId; }
    public void setUserId(int userId) { this.userId = userId; }

    public int getScheduleId() { return scheduleId; }
    public void setScheduleId(int scheduleId) { this.scheduleId = scheduleId; }

    public int getSeatId() { return seatId; }
    public void setSeatId(int seatId) { this.seatId = seatId; }

    public int getPaymentId() { return paymentId; }
    public void setPaymentId(int paymentId) { this.paymentId = paymentId; }

    public Timestamp getBookingDate() { return bookingDate; }
    public void setBookingDate(Timestamp bookingDate) { this.bookingDate = bookingDate; }

    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }
}
