package com.example.springpracticeproject_boardgames.controller;

import com.example.springpracticeproject_boardgames.config.DataLoader;
import com.example.springpracticeproject_boardgames.dto.BoardGameDTO;
import com.example.springpracticeproject_boardgames.repository.BoardGameRepository;
import com.example.springpracticeproject_boardgames.service.BoardGameService;
import com.example.springpracticeproject_boardgames.session.CartSession;
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
    private BoardGameRepository boardGameRepository;
//    private RestApiClient restApiClient;


    public BoardGameController(BoardGameService boardGameService, BoardGameRepository boardGameRepository) {
        this.boardGameService = boardGameService;
        this.boardGameRepository = boardGameRepository;
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
        boardGameService.addBoardGame(boardGameDTO);
        return "index.html";
    }


    @GetMapping("/display")
    public String getAllBoardgame(Model model) {
        List<BoardGameDTO> boardGames = boardGameService.getBoardGames();
        model.addAttribute("boardGames", boardGames);
//        System.out.println(boardGames);
        return "all-boardgames.html";
    }

    @GetMapping("/boardgames/{id}")
    public String getBoardGamePage(@PathVariable int id,  Model model) {
        System.out.println(id);
        BoardGameDTO boardGameDTO = boardGameService.findById(id);
        model.addAttribute("boardGame", boardGameDTO);
        return "boardgame-id.html";
    }

    @GetMapping("/cart-item")
    public String getCart(Model model) {
        model.addAttribute("games", cartSession.getBoardGames());
        return "cart-item.html";
    }

    @PostMapping("/add-to-cart/{boardGameId}")
    public String addToCart (@PathVariable int boardGameId){
        System.out.println("Koszyk przed dodaniem gry");
        System.out.println(cartSession);
        BoardGameDTO boardGameDTO = boardGameService.findById(boardGameId);
        cartSession.addBoardGame(boardGameDTO);
        return "index.html";
    }



}
