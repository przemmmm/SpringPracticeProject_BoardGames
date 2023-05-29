package com.example.springpracticeproject_boardgames.config;

import com.example.springpracticeproject_boardgames.entity.BoardGame;
import com.example.springpracticeproject_boardgames.entity.User;
import com.example.springpracticeproject_boardgames.enums.GameType;
import com.example.springpracticeproject_boardgames.repository.BoardGameRepository;
import com.example.springpracticeproject_boardgames.repository.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration

public class DataLoader {

    @Bean
    CommandLineRunner commandLineRunner(BoardGameRepository boardGameRepository) {
        return args -> {
            BoardGame dixit = new BoardGame();
            dixit.setTitle("Dixit");
            dixit.setGameType(GameType.valueOf("FAMILY"));
            dixit.setPrice(100.00);
            dixit.setQuantity(43);
            dixit.setFileName("https://gryplanszowe-basanti.pl/21504-medium_default/dixit-nowa-edycja.jpg");

        BoardGame splendor = new BoardGame("Splendor", GameType.STRATEGY, 80.0,12, "https://files.rebel.pl/products/100/606/_28615/rebel_gra_rodzinna_splendor_new_3d_okladka.png");
        BoardGame wsiacDoPociagu = new BoardGame("Wsiąśc do pociagu, Europa", GameType.STRATEGY, 150.0,20);
        BoardGame abyss = new BoardGame("Abyss", GameType.ADVENTURE, 130.99,6);
        BoardGame talizman = new BoardGame("Talizman", GameType.STRATEGY, 300.0,1);
            boardGameRepository.saveAll(List.of(dixit, splendor, wsiacDoPociagu, abyss, talizman));
        };
    }

    @Bean
    CommandLineRunner commandLineRunnerUser(UserRepository userRepository){
        return args -> {
            User user1 = new User();
            user1.setUserEmail("jan@gmail.com");
            user1.setPassword("123");
            userRepository.save(user1);
        };
    }

}
