package com.example.springpracticeproject_boardgames.config;

import com.example.springpracticeproject_boardgames.CartSession;
import com.example.springpracticeproject_boardgames.session.UserSession;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.context.annotation.SessionScope;

@Configuration
public class CartSessionConfig {
    @Bean
    @SessionScope
    public CartSession cartSession(){
        System.out.println("create!");
        return new CartSession();
    }
}
