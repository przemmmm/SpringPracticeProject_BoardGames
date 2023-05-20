package com.example.springpracticeproject_boardgames.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Entity
@Table(name="customers")
public class Customer {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "customer email")
    private String customerEmail;
    @Column(name = "password")
    private String password;

    public Customer(String customerEmail, String password) {
        this.customerEmail = customerEmail;
        this.password = password;
    }
}
