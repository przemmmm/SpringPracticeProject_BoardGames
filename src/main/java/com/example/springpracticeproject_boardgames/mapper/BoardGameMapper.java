package com.example.springpracticeproject_boardgames.mapper;

import com.example.springpracticeproject_boardgames.dto.BoardGameDTO;
import com.example.springpracticeproject_boardgames.entity.BoardGame;
import com.example.springpracticeproject_boardgames.enums.GameType;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class BoardGameMapper {
    public List<BoardGameDTO> mapToDtos(List<BoardGame> boardGames) {
        return boardGames.stream()
                .map(b -> mapToDto(b))
                .toList();
    }

    public List<BoardGame> mapToEntities(List<BoardGameDTO> boardGamesDTOS) {
        return boardGamesDTOS.stream()
                .map(b -> mapToEntity(b))
                .toList();
    }

    public BoardGameDTO mapToDto(BoardGame boardGame) {
        return BoardGameDTO.builder()
                .id(boardGame.getId())
                .title(boardGame.getTitle())
                .gameType(boardGame.getGameType().toString())
                .price(boardGame.getPrice())
                .quantity(boardGame.getQuantity())
                .fileName(boardGame.getFileName())
                .build();
    }

    public BoardGame mapToEntity(BoardGameDTO boardGamesDTO) {
        return new BoardGame(boardGamesDTO.getTitle(), GameType.valueOf(boardGamesDTO.getGameType()), boardGamesDTO.getPrice(), boardGamesDTO.getQuantity(), boardGamesDTO.getFileName());
    }
}
