package com.example.springpracticeproject_boardgames.mapper;

import com.example.springpracticeproject_boardgames.dto.OrderDTO;
import com.example.springpracticeproject_boardgames.entity.Order;

import java.time.LocalDateTime;

public class OrderMapper {
    public static Order mapToOrder(OrderDTO orderDto) {
        return Order.builder()
                .firstName(orderDto.getFirstName())
                .lastName(orderDto.getLastName())
                .address(orderDto.getAddress())
                .postCode(orderDto.getPostCode())
                .city(orderDto.getCity())
                .created(LocalDateTime.now())
                .build();
    }

}
