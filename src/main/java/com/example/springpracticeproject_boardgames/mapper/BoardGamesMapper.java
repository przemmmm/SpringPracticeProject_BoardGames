package com.example.springpracticeproject_boardgames.mapper;

import com.example.springpracticeproject_boardgames.dto.BoardGamesDTO;
import com.example.springpracticeproject_boardgames.entity.BoardGames;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class BoardGamesMapper {
    public List<BoardGamesDTO> mapToDtos(List<BoardGames> boardGames) {
        return boardGames.stream()
                .map(b -> mapToDto(b))
                .toList();
    }

    public List<BoardGames> mapToEntities(List<BoardGamesDTO> boardGamesDTOS) {
        return boardGamesDTOS.stream()
                .map(b -> mapToEntity(b))
                .toList();
    }

    public BoardGamesDTO mapToDto(BoardGames boardGames) {
        return BoardGamesDTO.builder()
                .id(boardGames.getId())
                .title(boardGames.getTitle())
                .gamesType((boardGames.getGamesType()))
                .price(boardGames.getPrice())
                .quantity(boardGames.getQuantity())
                .build();
    }

    public BoardGames mapToEntity(BoardGamesDTO boardGamesDTO) {
        return new BoardGames(boardGamesDTO.getTitle(), boardGamesDTO.getGamesType(), boardGamesDTO.getPrice(), boardGamesDTO.getQuantity());
    }
}
