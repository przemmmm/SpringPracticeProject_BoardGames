package com.example.springpracticeproject_boardgames.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class CartBoardGameDTO {
    private BoardGameDTO boardGame;
    private int counter;

    public CartBoardGameDTO(BoardGameDTO boardGameDTO){
        this.boardGame=boardGameDTO;
        this.counter=1;
    }
    public double getPrice(){
        return boardGame.getPrice()* counter;
    }
    public void increaseCounter(){
        counter++;
        getPrice();
    }
}
