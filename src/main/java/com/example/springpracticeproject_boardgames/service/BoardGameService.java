package com.example.springpracticeproject_boardgames.service;

import com.example.springpracticeproject_boardgames.dto.BoardGameDTO;
import com.example.springpracticeproject_boardgames.entity.BoardGame;
import com.example.springpracticeproject_boardgames.enums.GameType;
import com.example.springpracticeproject_boardgames.mapper.BoardGameMapper;
import com.example.springpracticeproject_boardgames.repository.BoardGameRepository;
import jakarta.annotation.PostConstruct;
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
    @PostConstruct
    public BoardGame firstBoardGame(){
        BoardGame boardGame1 = new BoardGame();
        boardGame1.setTitle("Dixit");
        boardGame1.setGameType(GameType.valueOf("FAMILY"));
        boardGame1.setPrice(100.00);
        boardGame1.setQuantity(43);
//        boardGame1.setDictionary("The cards have been revealed. Their common feature is a mysterious sentence, " +
//                "but only one of the cards is the key to it. Use your wits and intuition to avoid " +
//                "falling into the trap set by other players. Dixit is a cheerful and surprising " +
//                "game of associations to discover together with friends and family.");
        boardGameRepository.save(boardGame1);

        return boardGame1;
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
