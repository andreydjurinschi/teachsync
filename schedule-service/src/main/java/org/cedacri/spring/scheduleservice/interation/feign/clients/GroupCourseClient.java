package org.cedacri.spring.scheduleservice.interation.feign.clients;

import org.cedacri.spring.scheduleservice.interation.feign.requests.GroupCourseBaseInfoRequest;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "course-service" ,url = "http://localhost:8081/internal/teachsync/course")
public interface GroupCourseClient {
    @GetMapping("/{courseId}/group/{groupId}")
    GroupCourseBaseInfoRequest groupCourseBaseInfoRequest(@PathVariable("groupId")Long groupId, @PathVariable("courseId")Long courseId);
}
