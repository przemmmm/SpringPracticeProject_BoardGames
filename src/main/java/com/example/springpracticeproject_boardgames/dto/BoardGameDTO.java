package com.example.springpracticeproject_boardgames.dto;

import com.example.springpracticeproject_boardgames.enums.GameType;
import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@Builder
public class BoardGameDTO {
    private int id;
    private String title;
    // czy potrzebne @Enumerated???
    private String gameType;
    private Double price;
    private int quantity;
}

