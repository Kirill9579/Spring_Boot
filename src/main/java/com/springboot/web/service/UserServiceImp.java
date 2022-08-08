package com.springboot.web.service;

import com.springboot.web.model.User;
import com.springboot.web.repository.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import java.util.List;

@Service
public class UserServiceImp implements UserService {


    private final UsersRepository connDb;
    @Autowired
    public UserServiceImp(UsersRepository connDb) {
        this.connDb = connDb;
    }

    @Override
    @Transactional
    public void addUser(User user) {
        connDb.save(user);
    }

    @Override
    @Transactional
    public void removeUserById(int id) {
        connDb.deleteById(id);
    }

    @Override
    public List<User> getListUsers() {
        return connDb.findAll();
    }

    @Override
    public User getUserById(int id) {
        return connDb.findById(id).orElse(null);
    }

    @Override
    @Transactional
    public void updateUser(User user) {
        connDb.save(user);
    }
}
