package com.winylla.cheers.dao.impl;

import com.winylla.cheers.dao.UserRepositoryDAO;
import com.winylla.cheers.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class UserRepositoryImpl implements UserRepositoryDAO {

    /**
     * List of queries
     */
    private static final String INSERT_USER_QUERY = "INSERT INTO users(user_name, user_password, first_name, last_name) VALUES (?, ?, ?, ?)";
    private static final String UPDATE_USER_BY_ID_QUERY = "UPDATE users SET first_name=? WHERE id=?";
    private static final String GET_USER_BY_ID_QUERY = "SELECT * FROM users WHERE id=?";
    private static final String DELETE_USER_BY_ID_QUERY = "DELETE FROM users WHERE id=?";
    private static final String GET_ALL_USERS_QUERY = "SELECT * FROM users";

    private JdbcTemplate jdbcTemplate;

    @Autowired
    public UserRepositoryImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public User saveUser(User user) {
        jdbcTemplate.update(INSERT_USER_QUERY, user.getUserName(), user.getUserPassword(), user.getFirstName(), user.getLastName());
        return user; // need to return user with id
    }

    @Override
    public User updateUser(User user) {
        jdbcTemplate.update(UPDATE_USER_BY_ID_QUERY, user.getFirstName(), user.getId());
        return user;
    }

    @Override
    public User getById(int id) {
        return jdbcTemplate.queryForObject(GET_USER_BY_ID_QUERY, (resultSet, rowNum) -> {
            return new User(resultSet.getInt("id"), resultSet.getString("user_name"), resultSet.getString("user_password"), resultSet.getString("first_name"), resultSet.getString("last_name"));
        }, id);
    }

    @Override
    public String deleteById(int id) {
        jdbcTemplate.update(DELETE_USER_BY_ID_QUERY, id);
        return "User got deleted with id " + id;
    }

    @Override
    public List<User> allUsers() {
        return jdbcTemplate.query(GET_ALL_USERS_QUERY, (resultSet, rowNum) -> {
            return new User(resultSet.getInt("id"), resultSet.getString("user_name"), resultSet.getString("user_password"), resultSet.getString("first_name"), resultSet.getString("last_name"));
        });
    }
}
