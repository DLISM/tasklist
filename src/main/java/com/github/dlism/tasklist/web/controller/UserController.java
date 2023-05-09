package com.github.dlism.tasklist.web.controller;

import com.github.dlism.tasklist.model.task.Task;
import com.github.dlism.tasklist.model.user.User;
import com.github.dlism.tasklist.service.TaskService;
import com.github.dlism.tasklist.service.UserService;
import com.github.dlism.tasklist.web.dto.task.TaskDto;
import com.github.dlism.tasklist.web.dto.user.UserDto;
import com.github.dlism.tasklist.web.dto.validation.OnCreate;
import com.github.dlism.tasklist.web.dto.validation.OnUpdate;
import com.github.dlism.tasklist.web.mappers.TaskMapper;
import com.github.dlism.tasklist.web.mappers.UserMapper;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/users")
@RequiredArgsConstructor
@Validated
@Tag(name = "User Controller", description = "User API")
public class UserController {

    private final UserService userService;
    private final TaskService taskService;
    private final UserMapper userMapper;
    private final TaskMapper taskMapper;

    @PutMapping
    @Operation(summary = "Update user")
    public UserDto update(@Validated(OnUpdate.class) @RequestBody UserDto dto){
        User user = userMapper.userToEntity(dto);
        User updatedUser = userService.update(user);
        return userMapper.toDto(updatedUser);
    }

    @GetMapping("/{id}")
    @Operation(summary = "Get user by id")
    public UserDto getBbyId(@PathVariable Long id){
        User user = userService.getById(id);
        return userMapper.toDto(user);
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Delete user by id")
    public void delete(@PathVariable Long id){
        userService.delete(id);
    }

    @GetMapping("/{id}/tasks")
    @Operation(summary = "Get user task by id")
    public List<TaskDto> getTasksByUserId(@PathVariable Long id){
        List<Task> tasks = taskService.getAllByUserId(id);
        return taskMapper.toDto(tasks);
    }


    @PostMapping("/{id}/tasks")
    @Operation(summary = "Create task to user")
    public TaskDto createTask(@PathVariable Long id,
                              @Validated(OnCreate.class) @RequestBody TaskDto taskDto){

        Task task = taskMapper.toEntity(taskDto);
        Task createdTask  = taskService.create(task, id);

        return taskMapper.toDto(createdTask);
    }
}
