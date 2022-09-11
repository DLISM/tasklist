package com.github.dlism.tasklist.web.controller;

import com.github.dlism.tasklist.model.task.Task;
import com.github.dlism.tasklist.service.TaskService;
import com.github.dlism.tasklist.web.dto.task.TaskDto;
import com.github.dlism.tasklist.web.dto.validation.OnUpdate;
import com.github.dlism.tasklist.web.mappers.TaskMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/tasks")
@RequiredArgsConstructor
@Validated
public class TaskController {
    private final TaskService taskService;
    private final TaskMapper taskMapper;

    @GetMapping("/{id}")
    public TaskDto getById(@PathVariable Long  id){
        Task task = taskService.getById(id);

        return taskMapper.toDto(task);
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable Long id){
        taskService.delete(id);
    }

    @PutMapping
    public TaskDto update(@Validated(OnUpdate.class) @RequestBody TaskDto taskDto){
        Task task = taskMapper.toEntity(taskDto);
        Task updattedTask = taskService.update(task);

        return taskMapper.toDto(updattedTask);
    }


}
