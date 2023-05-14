package com.example.springpracticeproject_boardgames.dto;

import com.example.springpracticeproject_boardgames.enums.GamesType;
import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@Builder
public class BoardGamesDTO {
    private int id;
    private String title;
    // czy potrzebne @Enumerated???
    private GamesType gamesType;
    private Double price;
    private int quantity;
}
