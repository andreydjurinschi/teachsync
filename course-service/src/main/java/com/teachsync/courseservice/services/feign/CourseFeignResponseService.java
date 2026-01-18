package com.teachsync.courseservice.services.feign;

import com.teachsync.courseservice.domain.Course;
import com.teachsync.courseservice.domain.Group;
import com.teachsync.courseservice.interaction.feign.responses.GroupCourseResponseForScheduleService;
import com.teachsync.courseservice.repositories.CourseRepository;
import com.teachsync.courseservice.repositories.GroupRepository;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;

@Service
public class CourseFeignResponseService {

    private final GroupRepository groupRepository;
    private final CourseRepository courseRepository;

    public CourseFeignResponseService(GroupRepository groupRepository, CourseRepository courseRepository) {
        this.groupRepository = groupRepository;
        this.courseRepository = courseRepository;
    }

    public GroupCourseResponseForScheduleService getGroupCourse(Long groupId, Long courseId){

        Group group = groupRepository.findByGroupIdAndCourseId(groupId, courseId);
        Course course = courseRepository.findById(courseId).orElseThrow(() -> new NoSuchElementException("adasds"));
        return new GroupCourseResponseForScheduleService(
                groupId,
                courseId,
                group.getName(),
                course.getName()
        );
    }
}
