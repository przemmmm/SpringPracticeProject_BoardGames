package com.example.springpracticeproject_boardgames.repository;

import com.example.springpracticeproject_boardgames.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface CustomerRepository extends JpaRepository <Customer, Integer>{

    Optional<Customer> findByCustomerEmail(String customerEmail);
}
