package com.example.springpracticeproject_boardgames.config;

import com.example.springpracticeproject_boardgames.entity.BoardGame;
import com.example.springpracticeproject_boardgames.entity.User;
import com.example.springpracticeproject_boardgames.enums.GameType;
import com.example.springpracticeproject_boardgames.repository.BoardGameRepository;
import com.example.springpracticeproject_boardgames.repository.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration

public class DataLoader {

    @Bean
    CommandLineRunner commandLineRunner(BoardGameRepository boardGameRepository) {
        return args -> {
            BoardGame boardGame1 = new BoardGame();
            boardGame1.setTitle("Dixit");
            boardGame1.setGameType(GameType.valueOf("FAMILY"));
            boardGame1.setPrice(100.00);
            boardGame1.setQuantity(43);
            boardGameRepository.save(boardGame1);
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
