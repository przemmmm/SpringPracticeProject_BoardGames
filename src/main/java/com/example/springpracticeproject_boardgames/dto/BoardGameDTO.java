package com.example.springpracticeproject_boardgames.dto;

import com.example.springpracticeproject_boardgames.enums.GameType;
import lombok.*;
import org.springframework.web.multipart.MultipartFile;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@Builder
public class BoardGameDTO {
    private int id;
    private String title;
    // czy potrzebne @Enumerated???
    private String gameType;
    private Double price;
    private int quantity;
    private MultipartFile file;

    private String fileName;

    public BoardGameDTO(String title, String gameType, Double price, int quantity, String fileName) {
        this.title = title;
        this.gameType = gameType;
        this.price = price;
        this.quantity = quantity;
        this.fileName = fileName;
    }
}

