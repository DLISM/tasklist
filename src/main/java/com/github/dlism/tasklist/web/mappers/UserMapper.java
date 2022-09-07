package com.github.dlism.tasklist.web.mappers;

import com.github.dlism.tasklist.model.user.User;
import com.github.dlism.tasklist.web.dto.user.UserDto;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UserMapper {
    UserDto toDto(User user);
    User userToEntity(UserDto userDto);
}
