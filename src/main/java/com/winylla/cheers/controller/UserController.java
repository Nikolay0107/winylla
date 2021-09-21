package com.winylla.cheers.controller;

import com.winylla.cheers.dao.UserRepositoryDAO;
import com.winylla.cheers.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "user")
public class UserController {

    private final UserRepositoryDAO userRepositoryDAO;

    @Autowired
    public UserController(UserRepositoryDAO userRepositoryDAO) {
        this.userRepositoryDAO = userRepositoryDAO;
    }

    @PostMapping
    public User addUser(@RequestBody User user) {
        return userRepositoryDAO.saveUser(user);
    }

    @PutMapping
    public User updateUser(@RequestBody User user) {
        return userRepositoryDAO.updateUser(user);
    }

    @GetMapping("/{id}")
    public User getUser(@PathVariable("id") int id) {
        return userRepositoryDAO.getById(id);
    }

    @GetMapping
    public List<User> getUsers() {
        return userRepositoryDAO.allUsers();
    }

    @DeleteMapping("/{id}")
    public String deleteUser(@PathVariable("id") int id) {
        return userRepositoryDAO.deleteById(id);
    }

}
