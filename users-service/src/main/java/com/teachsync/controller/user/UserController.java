package com.teachsync.controller.user;

import com.teachsync.responses.dto.UserBaseDto;
import com.teachsync.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/teachsync/users")
public class UserController {
    private final UserService service;

    @Autowired
    public UserController(UserService service) {
        this.service = service;
    }

    @GetMapping("/all")
    public ResponseEntity<List<UserBaseDto>> getAll(){
        return ResponseEntity.ok(service.findAll());
    }
}
