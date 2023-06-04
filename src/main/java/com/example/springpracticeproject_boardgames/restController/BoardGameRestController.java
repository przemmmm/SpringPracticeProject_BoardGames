package com.example.springpracticeproject_boardgames.restController;

import com.example.springpracticeproject_boardgames.dto.BoardGameDTO;
import com.example.springpracticeproject_boardgames.service.BoardGameService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BoardGameRestController {

    private BoardGameService boardGameService;

    public BoardGameRestController(BoardGameService boardGameService) {
        this.boardGameService = boardGameService;
    }

    @PostMapping("/api/v1/boardgames")
    public void addBoardGame (@RequestBody BoardGameDTO boardGameDTO){
        System.out.println(boardGameDTO);
        boardGameService.addBoardGame(boardGameDTO);
    }
}
