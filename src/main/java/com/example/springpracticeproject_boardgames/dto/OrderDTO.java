package com.example.springpracticeproject_boardgames.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class OrderDTO {

    private int orderId;

    private String firstName;

    private String lastName;

    private String address;

    private String postCode;

    private String city;

    private LocalDateTime created;
}

