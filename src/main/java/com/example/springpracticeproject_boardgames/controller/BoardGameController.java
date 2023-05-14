package com.example.springpracticeproject_boardgames.controller;

import com.example.springpracticeproject_boardgames.dto.BoardGameDTO;
import com.example.springpracticeproject_boardgames.service.BoardGameService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Controller
public class BoardGameController {

    private BoardGameService boardGameService;

    public BoardGameController(BoardGameService boardGameService) {
        this.boardGameService = boardGameService;
    }

    @GetMapping("/home")
    public String getHomePage() {
        return "index.html";
    }

    @GetMapping("/add")
    public String getPage() {
        return "add-boardgame.html";
    }

    @PostMapping("/add")
    public String addBoardGame(BoardGameDTO boardGameDTO) {
        System.out.println(boardGameDTO);
        boardGameService.addBoardGame(boardGameDTO);
        return "index.html";
    }

    @GetMapping("/display")
    public String getAllBoardgame(Model model){
        List<BoardGameDTO> boardGames= boardGameService.getBoardGames();
        model.addAttribute("boardGames", boardGames);
        return "all-boardgames.html";
    }

}
