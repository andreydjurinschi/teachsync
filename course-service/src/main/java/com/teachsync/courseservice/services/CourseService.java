package com.teachsync.courseservice.services;

import com.teachsync.courseservice.domain.Course;
import com.teachsync.courseservice.mappers.CourseMapper;
import com.teachsync.courseservice.repositories.CourseRepository;
import com.teachsync.courseservice.responses.dto_s.CourseUpdateDto;
import com.teachsync.courseservice.responses.dto_s.course.CourseBaseDto;
import com.teachsync.courseservice.responses.dto_s.course.CourseCreateDto;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

@Service
public class CourseService {

    private final CourseRepository repository;

    @Autowired
    public CourseService(CourseRepository repository) {
        this.repository = repository;
    }

    public List<CourseBaseDto> findAll(){
        List<Course> courses = repository.findAll();
        return courses.stream().map(CourseMapper::mapToBaseDto).collect(Collectors.toList());
    }

    public CourseBaseDto findById(Long id){
        Course course = repository
                .findById(id)
                .orElseThrow(() -> new NoSuchElementException("this course does not exist"));
        return CourseMapper.mapToBaseDto(course);
    }

    @Transactional
    public void createCourse(CourseCreateDto dto){
        Course course = CourseMapper.mapToEntity(dto);
        repository.save(course);
    }

    @Transactional
    public void updateCourse(Long id, CourseUpdateDto dto){
        Course course = repository.findById(id).orElseThrow(
                () -> new NoSuchElementException("this course does not exist")
        );
        if(StringUtils.hasText(dto.getName())){
            course.setName(dto.getName());
        }
        if(StringUtils.hasText(dto.getDescription())){
            course.setDescription(dto.getDescription());
        }
        if(StringUtils.hasText(dto.getPhotoUrl())){
            course.setPhotoUrl(dto.getPhotoUrl());
        }
    }

    @Transactional
    public void deleteCourse(Long id){
        Course course = repository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("this course does not exist"));
        repository.delete(course);
    }


}
