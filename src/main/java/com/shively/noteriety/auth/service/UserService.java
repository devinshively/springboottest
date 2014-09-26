package com.shively.noteriety.auth.service;

import com.shively.noteriety.auth.domain.User;

import java.util.List;

public interface UserService {

    User register(User user);
    User findByUsername(String username);
    User find(Long id);
    List<User> getList();

}
