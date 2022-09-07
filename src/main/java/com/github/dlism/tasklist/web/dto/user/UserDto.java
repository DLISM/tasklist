package com.github.dlism.tasklist.web.dto.user;

import com.github.dlism.tasklist.model.task.Task;
import com.github.dlism.tasklist.model.user.Role;
import lombok.Data;

import java.util.List;
import java.util.Set;
@Data
public class UserDto {
    private Long id;
    private String name;
    private String username;
    private String password;
    private String passwordConfirmation;
}
