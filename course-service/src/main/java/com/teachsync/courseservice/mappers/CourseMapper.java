package com.teachsync.courseservice.mappers;

import com.teachsync.courseservice.domain.Course;
import com.teachsync.courseservice.requests.dto_s.course.CourseBaseDto;
import com.teachsync.courseservice.requests.dto_s.course.CourseCreateDto;

public class CourseMapper {

    //TODO: null till teacher verification logic is not created
    public static CourseBaseDto mapToBaseDto(Course course) {
        return new CourseBaseDto(
                course.getName(), course.getDescription(), course.getPhotoUrl(), null
        );
    }

    //TODO: null till teacher verification logic is not created
    public static Course mapToEntity(CourseCreateDto dto) {
        return new Course(
                dto.getName(), dto.getDescription(), dto.getPhotoUrl(), null
        );
    }
}
