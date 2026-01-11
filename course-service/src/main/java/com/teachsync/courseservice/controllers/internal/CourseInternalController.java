package com.teachsync.courseservice.controllers.internal;

import com.teachsync.courseservice.dto_s.courses.CourseBaseDto;
import com.teachsync.courseservice.services.domain.CourseService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/internal/teachsync/course")
public class CourseInternalController {

    private final CourseService courseService;

    public CourseInternalController(CourseService courseService) {
        this.courseService = courseService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<List<CourseBaseDto>> getCourseForUser(@PathVariable Long id){
        return ResponseEntity.status(HttpStatus.OK).body(courseService.getAllForUser(id));
    }
}
