package com.teachsync.dto.feign;

import java.util.Set;

public class UserWithCoursesDto {
    private String name;
    private String surname;
    private String email;
    private Set<String> courseNames;

    public UserWithCoursesDto(String name, String surname, String email, Set<String> courseNames) {
        this.name = name;
        this.surname = surname;
        this.email = email;
        this.courseNames = courseNames;
    }

    public UserWithCoursesDto() {
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

    public Set<String> getCourseNames() {
        return courseNames;
    }

    public void setCourseNames(Set<String> courseNames) {
        this.courseNames = courseNames;
    }
}
