package com.github.dlism.tasklist.web.dto.auth;

import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class JwtRequest {
    @NotNull(message = "username must by not null")
    private String username;
    @NotNull(message = "password must be not null")
    private String password;

}
