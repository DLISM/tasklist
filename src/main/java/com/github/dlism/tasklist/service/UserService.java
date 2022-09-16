package com.github.dlism.tasklist.service;

import com.github.dlism.tasklist.model.user.User;

public interface UserService {
    User getById(Long id);
    User getByUsername(String username);
    User update(User user);
    User create(User user);
    boolean isTaskOwner(Long userId, Long taskIid);
    void delete(Long idd);
}
