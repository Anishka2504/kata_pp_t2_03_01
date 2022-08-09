package edu.kata.task231.repository;

import edu.kata.task231.model.User;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public interface UserRepository {

    User findOne(Long id);

    List<User> findAll();

    User update(User user);

    User save(User user);

    void remove(Long id);
}
