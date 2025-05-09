package com.eBusTicketsWeb.model;

import java.sql.Timestamp;

public class Staff {
    private int id;
    private String name;
    private String email;
    private String password_hash;
    private String phone;
    private String role; 
    private Timestamp createdAt;

    // Constructors
    public Staff() {}

    public Staff(int id, String name, String email, String password_hash, String phone, String role, Timestamp createdAt) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.password_hash = password_hash;
        this.phone = phone;
        this.role = role;
        this.createdAt = createdAt;
    }

    // Getters and Setters
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public String getPassword() { return password_hash; }
    public void setPassword(String password_hash) { this.password_hash = password_hash; }

    public String getPhone() { return phone; }
    public void setPhone(String phone) { this.phone = phone; }

    public String getRole() { return role; }
    public void setRole(String role) { this.role = role; }

    public Timestamp getCreatedAt() { return createdAt; }
    public void setCreatedAt(Timestamp createdAt) { this.createdAt = createdAt; }
}
