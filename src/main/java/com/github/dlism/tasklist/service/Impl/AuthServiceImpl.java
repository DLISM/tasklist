package com.github.dlism.tasklist.service.Impl;

import com.github.dlism.tasklist.service.AuthService;
import com.github.dlism.tasklist.web.dto.auth.JwtRequest;
import com.github.dlism.tasklist.web.dto.auth.JwtResponse;
import org.springframework.stereotype.Service;

@Service
public class AuthServiceImpl implements AuthService {
    @Override
    public JwtResponse login(JwtRequest loginRequest) {
        return null;
    }

    @Override
    public JwtResponse refresh(String refreshToken) {
        return null;
    }
}
