package com.example.springpracticeproject_boardgames.service;

import com.example.springpracticeproject_boardgames.dto.BoardGameDTO;
import com.example.springpracticeproject_boardgames.entity.BoardGame;
import com.example.springpracticeproject_boardgames.enums.GameType;
import com.example.springpracticeproject_boardgames.mapper.BoardGameMapper;
import com.example.springpracticeproject_boardgames.repository.BoardGameRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BoardGameService {

    private BoardGameRepository boardGameRepository;
     private BoardGameMapper mapper;

    public BoardGameService(BoardGameRepository boardGameRepository, BoardGameMapper mapper) {
        this.boardGameRepository = boardGameRepository;
        this.mapper = mapper;
    }

    public void addBoardGame(BoardGameDTO boardGameDTO){
        BoardGame boardGame = mapper.mapToEntity(boardGameDTO);
        boardGameRepository.save(boardGame);

    }

     public List<BoardGameDTO> getBoardGames (){
        return boardGameRepository.findAll().stream()
                .map(boardGame -> new BoardGameDTO(boardGame.getTitle(),boardGame.getGameType().toString(),
                        boardGame.getPrice(), boardGame.getQuantity())).toList();
     }

}
