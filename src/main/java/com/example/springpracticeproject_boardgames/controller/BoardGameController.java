package com.example.springpracticeproject_boardgames.controller;

import com.example.springpracticeproject_boardgames.CartBoardGame;
import com.example.springpracticeproject_boardgames.CartSession;
import com.example.springpracticeproject_boardgames.config.CartSessionConfig;
import com.example.springpracticeproject_boardgames.config.DataLoader;
import com.example.springpracticeproject_boardgames.dto.BoardGameDTO;
import com.example.springpracticeproject_boardgames.entity.BoardGame;
import com.example.springpracticeproject_boardgames.repository.BoardGameRepository;
import com.example.springpracticeproject_boardgames.service.BoardGameService;
import jakarta.annotation.Resource;
import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Controller
public class BoardGameController {
    @Resource(name = "cartSession")
    private CartSession cartSession;

    private BoardGameService boardGameService;
    private DataLoader dataLoader;
    private BoardGameRepository boardGameRepository;

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

////    @GetMapping("/dixit")
//    public String firstBoardGamePage(Model model) {
//        BoardGame boardGame1;
//        model.addAttribute("firstBoardGame", boardGame1);
//        return "dixit.html";
//    }

    @GetMapping("/cart-item")
    public String getCart(HttpSession httpSession, Model model) {
        List<CartBoardGame> cartBoardGames = getCartItems(httpSession);
        model.addAttribute("cartBoardGame", cartBoardGames);
        return "cart-item.html";
    }

    @PostMapping("/add-to-cart")
    public String addToCart (@RequestParam int boardGameId, Model model, HttpSession session){
       List<BoardGame>cartBoardGames = (List<BoardGame>) session.getAttribute("cartBoardGame");
        if (cartBoardGames ==null){
            cartBoardGames = new ArrayList<>();
        }
        Optional<BoardGame> oCartBoardGames = boardGameRepository.findById(boardGameId);
        if (oCartBoardGames.isPresent()){
            BoardGame boardGameDTO = oCartBoardGames.get();
            cartBoardGames.add(boardGameDTO);
            session.setAttribute("cartBoardGame", cartBoardGames);
        }
        model.addAttribute("cartBoardGames", boardGameRepository.findAll());
        return "index.html";
    }

    public List<CartBoardGame> getCartItems(HttpSession session){
        List<CartBoardGame> cartBoardGames = (List<CartBoardGame>)session.getAttribute("cartBoardGame");
        if(cartBoardGames==null){
            cartBoardGames =new ArrayList<>();
            session.setAttribute("cartBoardGame", cartBoardGames);
            System.out.println("game added to cart");
        }
        return cartBoardGames;
    }


}
