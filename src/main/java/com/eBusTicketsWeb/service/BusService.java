package com.eBusTicketsWeb.service;


import com.eBusTicketsWeb.dao.BusDAO;
import com.eBusTicketsWeb.model.Bus;
import java.sql.SQLException;
import java.util.List;

public class BusService {
 private BusDAO busDAO;



 public BusService(BusDAO busDAO) {

	this.busDAO = busDAO;
}



public List<Bus> searchAllBusByScheduleId(int scheduleId) throws SQLException {
     return busDAO.getAllBusByScheduleId(scheduleId);
 }


}
