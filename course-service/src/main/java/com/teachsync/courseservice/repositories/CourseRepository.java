package com.teachsync.courseservice.repositories;

import com.teachsync.courseservice.domain.Course;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CourseRepository extends JpaRepository<Course, Long> {

}
