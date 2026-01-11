package com.teachsync.dto_s.course;

public class CourseBaseDto {
    private String name;
    private String description;
    private String photoUrl;
    private Long teacher;

    public CourseBaseDto(String name, String description, String photoUrl, Long teacher) {
        this.name = name;
        this.description = description;
        this.photoUrl = photoUrl;
        this.teacher = teacher;
    }

    public String getPhotoUrl() {
        return photoUrl;
    }

    public void setPhotoUrl(String photoUrl) {
        this.photoUrl = photoUrl;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Long getTeacher() {
        return teacher;
    }

    public void setTeacher(Long teacher) {
        this.teacher = teacher;
    }
}
