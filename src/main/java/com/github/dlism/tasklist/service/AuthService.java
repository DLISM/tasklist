package com.github.dlism.tasklist.service;

import com.github.dlism.tasklist.web.dto.auth.JwtRequest;
import com.github.dlism.tasklist.web.dto.auth.JwtResponse;

public interface AuthService {
    JwtResponse login(JwtRequest loginRequest);
    JwtResponse refresh(String refreshToken);
}
