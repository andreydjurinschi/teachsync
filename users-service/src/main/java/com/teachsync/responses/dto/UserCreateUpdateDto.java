package com.teachsync.responses.dto;

import com.teachsync.domain.Role;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;

import java.time.LocalDate;

public class UserCreateUpdateDto {

    @NotEmpty
    @Size(min = 2, max = 40, message = "invalid value for name")
    private String name;

    @NotEmpty
    @Size(min = 2, max = 40, message = "invalid value for surname")
    private String surname;

    @Size(min = 6, message = "password minimal range is 6 characters")
    @NotEmpty(message = "password is required")
    private String password;

    @NotEmpty
    @Size(min = 2, max = 40, message = "invalid value for email")
    @Email
    private String email;


    @NotEmpty
    private LocalDate registeredAt;

    @NotEmpty(message = "role cannot be null or empty")
    private Role role;

    public UserCreateUpdateDto(String name, String surname, String password, String email, LocalDate registeredAt, Role role) {
        this.name = name;
        this.surname = surname;
        this.password = password;
        this.email = email;
        this.registeredAt = registeredAt;
        this.role = role;
    }

    public LocalDate getRegisteredAt() {
        return registeredAt;
    }

    public void setRegisteredAt(LocalDate registeredAt) {
        this.registeredAt = registeredAt;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public UserCreateUpdateDto() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }
}
