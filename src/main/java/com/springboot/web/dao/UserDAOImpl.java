package com.springboot.web.dao;

import com.springboot.web.model.User;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class UserDAOImpl implements UserDAO {
    private EntityManager entityManager;

    @PersistenceContext
    public void setEntityManager(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public void addUser(User user) {
        entityManager.merge(user);
        System.out.println(".......................User save.....................");

    }

    @Override
    public void removeUserById(int id) {
        entityManager.remove(getUserById(id));

        System.out.println(".......................User delete.....................");
    }

    @Override
    public List<User> getListUsers() {
        System.out.println(".......................User list show.....................");
        return entityManager
                .createQuery("from User", User.class)
                .getResultList();
    }

    @Override
    public User getUserById(int id) {
        User user = entityManager.find(User.class, id);
        System.out.println(".......................User find.....................");
        return user;
    }

    @Override
    public void updateUser(User user) {
        addUser(user);
        System.out.println(".......................User update.....................");
    }


}
