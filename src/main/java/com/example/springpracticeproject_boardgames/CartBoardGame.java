package com.example.springpracticeproject_boardgames;

import com.example.springpracticeproject_boardgames.entity.BoardGame;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Data
//@NoArgsConstructor
//@AllArgsConstructor
@Getter
public class CartBoardGame {

    private BoardGame boardGame;
    private int counter;
    private Double price;


}

