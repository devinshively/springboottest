package com.shively.noteriety.auth.service;

import com.shively.noteriety.auth.domain.User;

import java.util.List;

public interface UserService {

    User save(User user);
    User findByUsername(String username);
    List<User> getList();

}
