package com.teachsync.courseservice.repositories;

import com.teachsync.courseservice.domain.Course;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface CourseRepository extends JpaRepository<Course, Long> {


    @Modifying(clearAutomatically = true, flushAutomatically = true)
    @Query(value = "UPDATE courses SET teacher_id = :teacherId WHERE id = :courseId", nativeQuery = true)
    int addTeacherForCourse(@Param("courseId") Long courseId,
                            @Param("teacherId") Long teacherId);

}
