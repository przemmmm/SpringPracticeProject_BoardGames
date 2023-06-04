package com.example.springpracticeproject_boardgames.controller;

import com.example.springpracticeproject_boardgames.CartBoardGame;
import com.example.springpracticeproject_boardgames.config.DataLoader;
import com.example.springpracticeproject_boardgames.dto.BoardGameDTO;
import com.example.springpracticeproject_boardgames.repository.BoardGameRepository;
import com.example.springpracticeproject_boardgames.service.BoardGameService;
import com.example.springpracticeproject_boardgames.session.CartSession;
import jakarta.annotation.Resource;
import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.ArrayList;
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
        //System.out.println(boardGameDTO);
        boardGameService.addBoardGame(boardGameDTO);
        return "index.html";
    }

//    @PostMapping("/add")
//    public String addBoardGame(BoardGameDTO boardGameDTO) {
//        //System.out.println(boardGameDTO);
//        restApiClient.sendAddBoardGameHttpRequest(boardGameDTO);
//        return "index.html";
//    }

    @GetMapping("/display")
    public String getAllBoardgame(Model model) {
        List<BoardGameDTO> boardGames = boardGameService.getBoardGames();
        model.addAttribute("boardGames", boardGames);
        System.out.println(boardGames);
        return "all-boardgames.html";
    }

    @GetMapping("/boardgames/{id}")
    public String getBoardGamePage(@PathVariable int id,  Model model) {
        System.out.println(id);
        BoardGameDTO boardGameDTO = boardGameService.findById(id);
        model.addAttribute("boardGame", boardGameDTO);
        return "boardgame-id.html";
    }
//    @PostMapping("/boardgames/{title}")
//    public String boardGamePage(BoardGameDTO boardGameDTO) {
//        System.out.println(boardGameDTO);
//        return "index.html";
//    }


    @GetMapping("/cart-item")
    public String getCart(HttpSession httpSession, Model model) {
        List<CartBoardGame> cartBoardGames = getCartItems(httpSession);
        model.addAttribute("cartBoardGame", cartBoardGames);
        return "cart-item.html";
    }
//    @GetMapping("/cart")
//    public String getCart(Model model) {
//        model.addAttribute("cart", cartSession);
//        return "cart.html";
//    }

    @PostMapping("/add-to-cart/{boardGameId}")
    public String addToCart (@PathVariable int boardGameId, Model model){
//       List<BoardGame>cartBoardGames = (List<BoardGame>) session.getAttribute("cartBoardGame");
//        System.out.println(boardGameId);
//        if (cartBoardGames ==null){
//            cartBoardGames = new ArrayList<>();
//        }
//        Optional<BoardGame> oCartBoardGames = boardGameRepository.findById(boardGameId);
//        if (oCartBoardGames.isPresent()){
//            BoardGame boardGameDTO = oCartBoardGames.get();
//            cartBoardGames.add(boardGameDTO);
//            session.setAttribute("cartBoardGame", cartBoardGames);
//        }
//        model.addAttribute("cartBoardGames", boardGameRepository.findAll());
//        System.out.println(boardGameRepository.findAll());
        System.out.println("Koszyk przed dodaniem gry");
        System.out.println(cartSession);
        BoardGameDTO boardGameDTO = boardGameService.findById(boardGameId);
        cartSession.addBoardGame(boardGameDTO);
        return "index.html";
    }
//    @PostMapping("/add-to-cart")
//    public String addToCart (BoardGameDTO boardGameDTO){
//        System.out.println(boardGameDTO);
//        return "index.html";
//    }

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
