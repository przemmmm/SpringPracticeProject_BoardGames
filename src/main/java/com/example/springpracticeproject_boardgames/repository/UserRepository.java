package com.example.springpracticeproject_boardgames.repository;

import com.example.springpracticeproject_boardgames.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository <User, Integer>{

    Optional<User> findByUserEmail(String userEmail);
}
