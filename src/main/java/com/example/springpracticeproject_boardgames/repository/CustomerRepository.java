package com.example.springpracticeproject_boardgames.repository;

import com.example.springpracticeproject_boardgames.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository <Customer, Integer>{
}
