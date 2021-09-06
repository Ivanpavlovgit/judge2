package com.example.judge2.repository;

import com.example.judge2.model.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface UserRepository extends JpaRepository<User,Long> {
    Optional<User> findByUsernameAndPassword (String username,String password);
    @Query("SELECT u.username from User u ORDER BY u.username")
    List<String> findAllUserNames();

    Optional<User> findByUsername (String username);
}
