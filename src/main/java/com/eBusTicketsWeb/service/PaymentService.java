package com.eBusTicketsWeb.service;
import com.eBusTicketsWeb.dao.PaymentDAO;
import com.eBusTicketsWeb.dao.TicketDAO;
import com.eBusTicketsWeb.model.Payment;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public class PaymentService {
	 private PaymentDAO paymentDAO;

	    public PaymentService(PaymentDAO paymentDAO) {
	        this.paymentDAO = paymentDAO;
	    }
    
  

    public int createPayment(Payment payment) throws SQLException {
        return paymentDAO.insertPayment(payment);
    }

    public List<Payment> getAllPayments() throws SQLException {
        return paymentDAO.getAllPayments();
    }

    public Payment getPayment(int id) throws SQLException {
        return paymentDAO.getPaymentById(id);
    }

    public void updatePayment(Payment payment) throws SQLException {
        paymentDAO.updatePayment(payment);
    }

    public void deletePayment(int id) throws SQLException {
        paymentDAO.deletePayment(id);
    }
}

