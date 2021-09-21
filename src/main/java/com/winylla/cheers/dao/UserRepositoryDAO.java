package com.winylla.cheers.dao;

import com.winylla.cheers.entity.User;

import java.util.List;

public interface UserRepositoryDAO {
    User saveUser(User user);
    User updateUser(User user);
    User getById(int id);
    String deleteById(int id);
    List<User> allUsers();
}
