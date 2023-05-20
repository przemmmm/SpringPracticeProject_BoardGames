package com.example.springpracticeproject_boardgames.config;

import com.example.springpracticeproject_boardgames.entity.BoardGame;
import com.example.springpracticeproject_boardgames.entity.Customer;
import com.example.springpracticeproject_boardgames.enums.GameType;
import com.example.springpracticeproject_boardgames.repository.BoardGameRepository;
import com.example.springpracticeproject_boardgames.repository.CustomerRepository;
import jakarta.annotation.PostConstruct;
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
    CommandLineRunner commandLineRunnerCustomer(CustomerRepository customerRepository){
        return args -> {
            Customer customer1 = new Customer();
            customer1.setCustomerEmail("jan@gmail.com");
            customer1.setPassword("123");
            customerRepository.save(customer1);
        };
    }

}
