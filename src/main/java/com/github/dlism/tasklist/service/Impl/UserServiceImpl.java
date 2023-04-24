package com.github.dlism.tasklist.service.Impl;

import com.github.dlism.tasklist.model.exception.ResourceNotFoundException;
import com.github.dlism.tasklist.model.user.User;
import com.github.dlism.tasklist.repository.UserRepository;
import com.github.dlism.tasklist.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;

    @Override
    public User getById(Long id) {
        return userRepository.findById(id)
                .orElseThrow(()-> new ResourceNotFoundException("User not find"));
    }

    @Override
    public User getByUsername(String username) {
        return null;
    }


    @Override
    public User update(User user) {
        return null;
    }

    @Override
    public User create(User user) {
        return null;
    }

    @Override
    public boolean isTaskOwner(Long userId, Long taskIid) {
        return false;
    }

    @Override
    public void delete(Long idd) {

    }
}
