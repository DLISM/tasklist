package com.github.dlism.tasklist.web.mappers;

import com.github.dlism.tasklist.model.task.Task;
import com.github.dlism.tasklist.web.dto.task.TaskDto;
import com.github.dlism.tasklist.web.dto.user.UserDto;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface TaskMapper {
    TaskDto toDto(Task task);

    List<TaskDto> toDto(List<Task>  tasks);

    Task toEntity(TaskDto taskDto);
}
