package com.teachsync.courseservice.services.feign;

import com.teachsync.courseservice.requests.feign.TeacherCheckResponse;
import com.teachsync.courseservice.utils.FeignLogger;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "user-service", url = "http://localhost:8080/internal/teachsync/users", configuration = FeignLogger.class)
public interface UserClient {
    @GetMapping("/{id}/teacher")
    TeacherCheckResponse isTeacher(@PathVariable Long id);
}
