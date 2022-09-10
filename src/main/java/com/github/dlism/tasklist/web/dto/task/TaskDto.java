package com.github.dlism.tasklist.web.dto.task;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.github.dlism.tasklist.model.task.Status;
import com.github.dlism.tasklist.web.dto.validation.OnCreate;
import com.github.dlism.tasklist.web.dto.validation.OnUpdate;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import org.hibernate.validator.constraints.Length;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;
@Data
public class TaskDto {
    @NotNull(message = "id must be not null", groups = OnUpdate.class)
    private Long id;

    @NotNull(message = "Title must be not null", groups = {OnUpdate.class, OnCreate.class})
    @Length(max = 255, message = "Title length must be smaller the 255 symbols", groups = {OnUpdate.class, OnCreate.class})
    private String title;

    @Length(max = 255, message = "Description length must be smaller the 255 symbols", groups = {OnUpdate.class, OnCreate.class})
    private String description;

    private Status status;

    @DateTimeFormat(iso = DateTimeFormat.ISO.TIME)
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm")
    private LocalDateTime expirationDate;
}
