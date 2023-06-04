package com.example.springpracticeproject_boardgames.session;

import com.example.springpracticeproject_boardgames.dto.BoardGameDTO;
import com.example.springpracticeproject_boardgames.dto.CartBoardGameDTO;
import com.example.springpracticeproject_boardgames.repository.BoardGameRepository;
import lombok.Getter;
import lombok.ToString;

import java.util.ArrayList;
import java.util.List;

@Getter
@ToString
public class CartSession {
    private CartBoardGameDTO cartBoardGameDTO;
    private BoardGameRepository boardGameRepository;
    private List<CartBoardGameDTO> boardGames = new ArrayList<>();

    public void addBoardGame(BoardGameDTO boardGameDTO) {
        CartBoardGameDTO cartBoardGameDTO = new CartBoardGameDTO(boardGameDTO, 1);
        boardGames.add(cartBoardGameDTO);
    }

}

