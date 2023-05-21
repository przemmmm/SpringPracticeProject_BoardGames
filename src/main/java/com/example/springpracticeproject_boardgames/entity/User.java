package com.example.springpracticeproject_boardgames.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
@Table(name="Users")
public class User {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "user_email")
    private String userEmail;
    @Column(name = "password")
    private String password;

    public User(String userEmail, String password) {
        this.userEmail = userEmail;
        this.password = password;
    }
}
