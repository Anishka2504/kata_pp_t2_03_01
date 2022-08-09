package edu.kata.task231.repository.impl;

import edu.kata.task231.model.User;
import edu.kata.task231.repository.UserRepository;
import org.springframework.stereotype.Component;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

public class UserRepositoryImpl implements UserRepository {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public User findOne(Long id) {
        return entityManager.find(User.class, id);
    }

    @Override
    public List<User> findAll() {
        return entityManager.createQuery("SELECT usr FROM User usr").getResultList();
    }

    @Override
    public User update(User user) {
        if (user.getId() == null) {
            entityManager.persist(user);
            entityManager.flush();
            return user;
        } else {
            return entityManager.merge(user);
        }
    }

    @Override
    public User save(User user) {
        entityManager.persist(user);
        entityManager.flush();
        return user;
    }

    @Override
    public void remove(Long id) {
        User user = entityManager.find(User.class, id);
        entityManager.remove(user);
    }
}
