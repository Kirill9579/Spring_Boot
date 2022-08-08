package com.springboot.web.dao;

import com.springboot.web.model.User;

import java.util.List;

public interface UserDAO {
    void addUser(User user);
    void removeUserById(int id);
    List<User> getListUsers();
    User getUserById(int id);
    void updateUser(User user);

}
