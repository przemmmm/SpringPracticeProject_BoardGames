package com.example.springpracticeproject_boardgames.entity;


import com.example.springpracticeproject_boardgames.enums.GameType;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Entity
@Getter
@Setter
@Table(name = "board games")
public class BoardGame {
    @Column(name = "Id")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int boardGameId;
    @Column(name = "Title")
    private String title;
    @Column(name = "Type")
    @Enumerated(EnumType.STRING)
    private GameType gameType;
    @Column(name = "Price")
    private Double price;
    @Column(name = "Quantity")
    private int quantity;
    @Column(name = "File Name")
    private String fileName;

    public BoardGame(String title, GameType gameType, Double price, int quantity, String fileName) {
        this.title = title;
        this.gameType = gameType;
        this.price = price;
        this.quantity = quantity;
        this.fileName = fileName;
    }

    public BoardGame(String title, GameType gameType, Double price, int quantity) {
        this.title = title;
        this.gameType = gameType;
        this.price = price;
        this.quantity = quantity;
    }

    public String getFileNameWithId() {
        return boardGameId + "-"+fileName;
    }
}
