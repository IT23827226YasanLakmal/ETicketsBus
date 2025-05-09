package com.eBusTicketsWeb.model;

import java.sql.Timestamp;

public class Ticket {
    private int id;
    private int userId;
    private int scheduleId;
    private int busId;
    private int paymentId;
    private Timestamp bookingDate;
    private String status;
    

    public Ticket(){
    	
    }
    public Ticket(int userId, int scheduleId, int busId ,int paymentId, Timestamp bookingDate, String status) {
		super();
		
		this.userId = userId;
		this.scheduleId = scheduleId;
		this.busId = busId;
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


    public int getBusId() {
		return busId;
	}
	public void setBusId(int busId) {
		this.busId = busId;
	}
	public int getPaymentId() { return paymentId; }
    public void setPaymentId(int paymentId) { this.paymentId = paymentId; }

    public Timestamp getBookingDate() { return bookingDate; }
    public void setBookingDate(Timestamp bookingDate) { this.bookingDate = bookingDate; }

    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }
}
