package com.github.dlism.tasklist.web.controller;

import com.github.dlism.tasklist.model.user.User;
import com.github.dlism.tasklist.service.AuthService;
import com.github.dlism.tasklist.service.UserService;
import com.github.dlism.tasklist.web.dto.auth.JwtRequest;
import com.github.dlism.tasklist.web.dto.auth.JwtResponse;
import com.github.dlism.tasklist.web.dto.user.UserDto;
import com.github.dlism.tasklist.web.dto.validation.OnCreate;
import com.github.dlism.tasklist.web.mappers.UserMapper;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/auth")
@RequiredArgsConstructor
@Validated
@Tag(name = "Auth Controller", description = "Auth API")
public class AuthController {

    private final AuthService authService;
    private final UserService userService;
    private final UserMapper userMapper;

    @PostMapping("/login")
    public JwtResponse login(@Validated @RequestBody JwtRequest loginRequest) {
        return authService.login(loginRequest);
    }

    @PostMapping("/register")
    public UserDto register(@Validated(OnCreate.class) @RequestBody UserDto userDto) {
        User user = userMapper.userToEntity(userDto);
        User createUser = userService.create(user);

        return userMapper.toDto(createUser);
    }

    @PostMapping("/refresh")
    public JwtResponse refresh(@RequestBody String refreshToken) {
        return authService.refresh(refreshToken);
    }
}