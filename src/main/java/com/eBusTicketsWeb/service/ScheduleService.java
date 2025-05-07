package com.eBusTicketsWeb.service;

import com.eBusTicketsWeb.dao.ScheduleDAO;
import com.eBusTicketsWeb.model.Schedule;

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

    public List<Schedule> getAllSchedules() throws SQLException {
        return scheduleDAO.getAllSchedules();
    }

    public Schedule getScheduleById(int id) throws SQLException {
        return scheduleDAO.getScheduleById(id);
    }

    public void removeSchedule(int id) throws SQLException {
        scheduleDAO.deleteSchedule(id);
    }
}