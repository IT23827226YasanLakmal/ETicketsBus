package com.eBusTicketsWeb.service;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.eBusTicketsWeb.dao.UserDAO;
import com.eBusTicketsWeb.model.RegisterRequest;
import com.eBusTicketsWeb.model.User;
import com.eBusTicketsWeb.util.PasswordUtil;

public class UserService {
    private UserDAO userDAO;

    public UserService(UserDAO userDAO) {
        this.userDAO = userDAO;
    }
    
    public boolean authenticate(String username, String password) throws SQLException {
        Optional<User> userOpt = userDAO.findByUsername(username);

        if (userOpt.isEmpty()) {
            return false;
        }

        User user = userOpt.get();
        try {
            return PasswordUtil.verifyPassword(password, user.getPasswordHash());
        } catch (Exception e) {
            return false;
        }
    }
    
    public boolean register(String username, String email, String password, String phone) throws Exception {
        if (userDAO.findByUsername(username).isPresent()) {
			return false;
		}

        User user = new User();

        user.setUsername(username);
        user.setEmail(email);
        user.setPasswordHash(PasswordUtil.hashPassword(password));
        user.setPhone(phone);
        return userDAO.save(user);
    }


    public List<String> validateRegistration(RegisterRequest request) throws SQLException {
        List<String> errors = new ArrayList<>();

        if (request.getUsername() == null || request.getUsername().isEmpty()) {
            errors.add("Username is required.");
        }

        if (request.getPassword() == null || request.getPassword().length() < 8) {
            errors.add("Password must be at least 8 characters.");
        }

        if (!request.getPassword().equals(request.getConfirmPassword())) {
            errors.add("Passwords do not match.");
        }

        if (userDAO.findByUsername(request.getUsername()).isPresent()) {
            errors.add("Username already taken.");
        }

        return errors;
    }
}

