package com.github.dlism.tasklist.service.Impl;

import com.github.dlism.tasklist.model.user.User;
import com.github.dlism.tasklist.service.UserService;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    @Override
    public User getById(Long id) {
        return null;
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
