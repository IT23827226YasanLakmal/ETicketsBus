package com.eBusTicketsWeb.service;

import com.eBusTicketsWeb.dao.ScheduleDAO;
import com.eBusTicketsWeb.model.Schedule;
import com.eBusTicketsWeb.model.ScheduleResult;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public class ScheduleService {
    private final ScheduleDAO scheduleDAO;

    public ScheduleService(Connection connection) {
        this.scheduleDAO = new ScheduleDAO(connection);
    }

    public void createSchedule(Schedule schedule) throws SQLException {
        scheduleDAO.addSchedule(schedule);
    }

    public List<ScheduleResult> fetchAllSchedules() throws SQLException {
        return scheduleDAO.getAllSchedules();
    }

    public List<ScheduleResult> getScheduleBySearch(String from, String to, String date) throws SQLException {
        return scheduleDAO.getScheduleBySearch(from, to, date);
    }

    public void removeSchedule(int id) throws SQLException {
        scheduleDAO.deleteSchedule(id);
    }
}