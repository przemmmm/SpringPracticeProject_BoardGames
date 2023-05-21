package com.example.springpracticeproject_boardgames.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table (name = "orders")
@Builder
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "order_id")
    private int orderId;
    @Column(name = "first_name")
    private String firstName;
    @Column(name = "last_name")
    private String lastName;
    @Column(name = "address")
    private String address;
    @Column(name = "post_code")
    private String postCode;
    @Column(name = "city")
    private String city;
    @Column(name = "order_time")
    private LocalDateTime created;

    @OneToMany(mappedBy = "order")
    private List<OrderItem> orderItems;
}
