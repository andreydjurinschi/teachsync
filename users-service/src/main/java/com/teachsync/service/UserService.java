package com.teachsync.service;

import com.teachsync.domain.User;
import com.teachsync.mapper.UserMapper;
import com.teachsync.repository.UserRepository;
import com.teachsync.responses.dto.UserBaseDto;
import com.teachsync.responses.dto.UserCreateUpdateDto;
import com.teachsync.utils.PasswordUtils;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

@Service
public class UserService {
    private final UserRepository repository;

    @Autowired
    public UserService(UserRepository repository) {
        this.repository = repository;
    }

    public List<UserBaseDto> findAll(){
        List<UserBaseDto> dtos = new ArrayList<>();
        for(var user : repository.findAll()){
            dtos.add(UserMapper.mapToBaseDto(user));
        }
        return dtos;
    }

    public UserBaseDto findById(Long id){
        User user = repository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Given user does not exist"));
        return UserMapper.mapToBaseDto(user);
    }

    @Transactional
    public void createUser(UserCreateUpdateDto dto){
        User user = UserMapper.mapToUser(dto);
        user.setPassword(PasswordUtils.hash(user.getPassword()));
        repository.save(user);
    }

    @Transactional
    public void updateUser(Long id, UserCreateUpdateDto dto) {

        User user = repository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("User not found"));

        if (dto.getName() != null) user.setName(dto.getName());
        if (dto.getSurname() != null) user.setSurname(dto.getSurname());
        if (dto.getEmail() != null) user.setEmail(dto.getEmail());
        if (dto.getRole() != null) user.setRole(dto.getRole());
        if (dto.getRegisteredAt() != null) user.setRegisteredAt(dto.getRegisteredAt());

        if (dto.getPassword() != null && !dto.getPassword().isBlank()) {
            user.setPassword(PasswordUtils.hash(dto.getPassword()));
        }
    }
}
