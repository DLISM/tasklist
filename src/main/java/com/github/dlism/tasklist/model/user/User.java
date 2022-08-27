package com.github.dlism.tasklist.model.user;

import com.github.dlism.tasklist.model.task.Task;
import lombok.Data;

import java.util.List;
import java.util.Set;

@Data
public class User {
    private Long id;
    private String nam;
    private String username;
    private String password;
    private String passwordConfirmation;
    private Set<Role> roles;
    private List<Task> tasks;
}
