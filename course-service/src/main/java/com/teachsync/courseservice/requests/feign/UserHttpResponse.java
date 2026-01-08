package com.teachsync.courseservice.requests.feign;

import java.time.LocalDate;

public class UserHttpResponse {
    private String fullName;
    private String email;
    private LocalDate registeredAt;
    private Role role;

    public UserHttpResponse(String fullName, String email, LocalDate registeredAt, Role role) {
        this.fullName = fullName;
        this.email = email;
        this.registeredAt = registeredAt;
        this.role = role;
    }

    public UserHttpResponse() {
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public LocalDate getRegisteredAt() {
        return registeredAt;
    }

    public void setRegisteredAt(LocalDate registeredAt) {
        this.registeredAt = registeredAt;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }
}

