package com.springboot.web.service;

import com.springboot.web.dao.UserDAO;
import com.springboot.web.model.User;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import java.util.List;

@Service
public class UserServiceImp implements UserService {


    private final UserDAO connDb;
    @Autowired
    public UserServiceImp(UserDAO connDb) {
        this.connDb = connDb;
    }

    @Override
    @Transactional
    public void addUser(User user) {
        connDb.addUser(user);
    }

    @Override
    @Transactional
    public void removeUserById(int id) {
        connDb.removeUserById(id);
    }

    @Override
    public List<User> getListUsers() {
        return connDb.getListUsers();
    }

    @Override
    public User getUserById(int id) {
        return connDb.getUserById(id);
    }

    @Override
    @Transactional
    public void updateUser(User user) {
        connDb.updateUser(user);
    }
}
