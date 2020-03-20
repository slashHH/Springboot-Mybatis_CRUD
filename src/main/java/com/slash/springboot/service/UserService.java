package com.slash.springboot.service;

import com.slash.springboot.entity.User;

public interface UserService extends BaseService<User> {
    User findByName(String name);
}
