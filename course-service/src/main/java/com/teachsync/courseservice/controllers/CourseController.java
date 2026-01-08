package com.teachsync.courseservice.controllers;

import com.teachsync.courseservice.requests.dto_s.course.CourseUpdateDto;
import com.teachsync.courseservice.requests.dto_s.course.CourseBaseDto;
import com.teachsync.courseservice.requests.dto_s.course.CourseCreateDto;
import com.teachsync.courseservice.services.domain.CourseService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/teachsync/courses")
public class CourseController {

    private final CourseService courseService;

    @Autowired
    public CourseController(CourseService courseService) {
        this.courseService = courseService;
    }

    @GetMapping("/all")
    public ResponseEntity<List<CourseBaseDto>> findAll(){
        return ResponseEntity.status(HttpStatus.OK).body(courseService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<CourseBaseDto> findById(@PathVariable Long id){
        return ResponseEntity.status(HttpStatus.OK).body(courseService.findById(id));
    }

    @GetMapping("/checkUser/{id}")
    public ResponseEntity<String> checkTeacher(@PathVariable Long id){
        return ResponseEntity.status(HttpStatus.OK).body(courseService.findUserTest(id));
    }

    @PutMapping("/edit/{id}")
    public ResponseEntity<Void> update(@PathVariable Long id, @Valid @RequestBody CourseUpdateDto dto){
        courseService.updateCourse(id, dto);
        return ResponseEntity.status(HttpStatus.CREATED).body(null);
    }

    @PostMapping("/create")
    public ResponseEntity<Void> create(@RequestBody @Valid CourseCreateDto dto){
        courseService.createCourse(dto);
        return ResponseEntity.status(HttpStatus.CREATED).body(null);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id){
        courseService.deleteCourse(id);
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(null);
    }
}
