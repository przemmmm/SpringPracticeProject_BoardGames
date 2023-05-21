package com.example.springpracticeproject_boardgames;
//
import com.example.springpracticeproject_boardgames.dto.BoardGameDTO;
import com.example.springpracticeproject_boardgames.entity.BoardGame;
import lombok.Getter;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
//
//
@Getter
public class CartSession {
        private String name = "Dixit";
//    private List<CartBoardGame> cartBoardGames = new ArrayList<>();
//    private int counter;
//    private Double sum;
//
//
//    public void addBoardGame(BoardGameDTO boardGameDTO) {
//        getBoardGame(boardGameDTO).ifPresentOrElse(CartBoardGame::increaseCounter,
//                () -> cartBoardGames.add(new CartBoardGame(b)));
//    }
//
//    private Optional<CartBoardGame> getBoardGame(BoardGameDTO boardGameDTO) {
//        return cartBoardGames.stream().findFirst();
//    }
}
