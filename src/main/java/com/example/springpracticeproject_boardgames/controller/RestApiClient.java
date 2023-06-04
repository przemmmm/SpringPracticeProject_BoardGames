//package com.example.springpracticeproject_boardgames.controller;
//
//import com.example.springpracticeproject_boardgames.dto.BoardGameDTO;
//import lombok.Setter;
//import org.springframework.web.client.RestTemplate;
//
//@Setter
//public class RestApiClient {
//    public void sendAddBoardGameHttpRequest(BoardGameDTO boardGameDTO){
//        RestTemplate restTemplate = new RestTemplate();
//        restTemplate.postForObject("http://localhost:8080/api/v1/boardgames", boardGameDTO, String.class);
//    }
//}
