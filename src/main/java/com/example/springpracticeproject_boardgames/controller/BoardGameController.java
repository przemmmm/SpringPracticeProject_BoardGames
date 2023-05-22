package com.example.springpracticeproject_boardgames.controller;

import com.example.springpracticeproject_boardgames.CartSession;
import com.example.springpracticeproject_boardgames.config.DataLoader;
import com.example.springpracticeproject_boardgames.dto.BoardGameDTO;
import com.example.springpracticeproject_boardgames.service.BoardGameService;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class BoardGameController {
    @Resource(name = "cartSession")
    private CartSession cartSession;

    private BoardGameService boardGameService;
    private DataLoader dataLoader;

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
        //System.out.println(boardGameDTO);
        boardGameService.addBoardGame(boardGameDTO);
        return "index.html";
    }

    @GetMapping("/display")
    public String getAllBoardgame(Model model) {
        List<BoardGameDTO> boardGames = boardGameService.getBoardGames();
        model.addAttribute("boardGames", boardGames);
        return "all-boardgames.html";
    }

    @GetMapping("/boardgames/{title}")
    public String getBoardGamePage(@PathVariable String title, Model model) {
        System.out.println(title);
        return "boardgame-id.html";
    }

//    @PostMapping("/boardgame/{title}")
//    public String boardGamePage(BoardGameDTO boardGameDTO) {
//        System.out.println(boardGameDTO);
//        return "index.html";
//    }


    @GetMapping("/cart")
    public String getCart(Model model) {
        model.addAttribute("cart", cartSession);
        return "cart.html";
    }

    @PostMapping("/add-to-cart")
    public String addToCart (BoardGameDTO boardGameDTO){
        System.out.println(boardGameDTO);
        return "index.html";
    }
}
