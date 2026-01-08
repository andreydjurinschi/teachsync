package com.teachsync.courseservice.services.feign;

import com.teachsync.courseservice.requests.feign.UserHttpResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.NoSuchElementException;

@FeignClient(name = "user-service", url = "http://localhost:8080/teachsync/users")
public interface UserClient {
    @GetMapping("/{id}")
    UserHttpResponse checkUserExists(@PathVariable Long id) throws NoSuchElementException;
}
