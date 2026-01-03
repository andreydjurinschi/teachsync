package com.teachsync.mapper;

import com.teachsync.domain.User;
import com.teachsync.responses.dto.UserBaseDto;
import com.teachsync.responses.dto.UserCreateUpdateDto;

public class UserMapper {
    public static UserBaseDto mapToBaseDto(User user){
        return new UserBaseDto(
                user.getName() + " " + user.getSurname(), user.getEmail(), user.getRegisteredAt(), user.getRole()
        );
    }

    public static User mapToUser(UserCreateUpdateDto dto){
        return new User(
                dto.getName(),
                dto.getSurname(),
                dto.getEmail(),
                null,
                dto.getRegisteredAt(),
                dto.getRole()
        );
    }
}
