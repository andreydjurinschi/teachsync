package com.teachsync.interaction;

import com.teachsync.interaction.requests.CourseBaseInfoRequest;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(name = "course-service", url = "http://localhost:8081/internal/teachsync/course")
public interface CourseClient {

    @GetMapping("/{id}")
    List<CourseBaseInfoRequest> requestForCourseInfo(@PathVariable Long id);
}
