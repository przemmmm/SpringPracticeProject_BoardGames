package com.example.springpracticeproject_boardgames.service;

import com.example.springpracticeproject_boardgames.dto.RegisterDTO;
import com.example.springpracticeproject_boardgames.entity.Customer;
import com.example.springpracticeproject_boardgames.repository.CustomerRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class CustomerService {
    private CustomerRepository customerRepository;

    public CustomerService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    public void createCustomer (RegisterDTO registerDTO){
        Customer customer = new Customer(registerDTO.getCustomerEmail(),registerDTO.getPassword1());
        customerRepository.save(customer);
    }
}
