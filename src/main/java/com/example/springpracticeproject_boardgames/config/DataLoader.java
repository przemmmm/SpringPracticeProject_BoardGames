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
            dixit.setFileName("https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSKwnzn5LUqir1Gx3_ZKqELAbUX4XTSTmfL4Q&usqp=CAU");

        BoardGame splendor = new BoardGame("Splendor", GameType.STRATEGY, 80.0,12, "https://image.ceneostatic.pl/data/products/31303245/i-splendor.jpg");
        BoardGame wsiacDoPociagu = new BoardGame("Wsiąśc do pociagu, Europa", GameType.STRATEGY, 150.0,20, "https://ecsmedia.pl/c/rebel-gra-planszowa-wsiasc-do-pociagu-europa-b-iext126537443.jpg");
        BoardGame abyss = new BoardGame("Abyss", GameType.ADVENTURE, 130.99,6, "https://mepel.pl/userdata/public/gfx/37696/abyss_3d.jpg");
        BoardGame talisman = new BoardGame("Talisman", GameType.STRATEGY, 300.0,1, "https://pegaz-gry.pl/img/p/3/1/8/5/3185-large_default.webp");
            boardGameRepository.saveAll(List.of(dixit, splendor, wsiacDoPociagu, abyss, talisman));
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
