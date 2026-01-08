package com.teachsync.courseservice.services.domain;

import com.teachsync.courseservice.domain.Course;
import com.teachsync.courseservice.mappers.CourseMapper;
import com.teachsync.courseservice.repositories.CourseRepository;
import com.teachsync.courseservice.requests.dto_s.course.CourseUpdateDto;
import com.teachsync.courseservice.requests.dto_s.course.CourseBaseDto;
import com.teachsync.courseservice.requests.dto_s.course.CourseCreateDto;
import com.teachsync.courseservice.requests.feign.Role;
import com.teachsync.courseservice.requests.feign.UserHttpResponse;
import com.teachsync.courseservice.services.feign.UserClient;
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
    private final UserClient userClient;

    @Autowired
    public CourseService(CourseRepository repository, UserClient userClient) {
        this.repository = repository;
        this.userClient = userClient;
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

    public String findUserTest(Long id){
        StringBuilder res = new StringBuilder();
        UserHttpResponse resp = userClient.checkUserExists(id);
        if(resp.getRole() != Role.TEACHER){
            res.append(String.format("User %s is not a teacher, he is %s", resp.getFullName(), resp.getRole().toString()));
        }else {
            res.append(String.format("User %s is a teacher, his email is %s", resp.getFullName(), resp.getEmail()));
        }
        return res.toString();
    }


}
