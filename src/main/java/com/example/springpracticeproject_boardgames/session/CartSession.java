package com.example.springpracticeproject_boardgames.session;

import com.example.springpracticeproject_boardgames.dto.BoardGameDTO;
import lombok.Getter;
import lombok.ToString;

import java.util.ArrayList;
import java.util.List;

@Getter
@ToString
public class CartSession {
    private List<BoardGameDTO> boardGames = new ArrayList<>();

    public void addBoardGame (BoardGameDTO boardGameDTO){
        boardGames.add(boardGameDTO);
    }
}
