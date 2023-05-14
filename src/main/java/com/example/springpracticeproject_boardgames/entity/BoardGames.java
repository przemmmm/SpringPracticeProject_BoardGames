package com.example.springpracticeproject_boardgames.entity;


import com.example.springpracticeproject_boardgames.enums.GamesType;
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
public class BoardGames {
    @Column(name = "Id")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "Title")
    private String title;
    @Column(name = "Type")
    @Enumerated(EnumType.STRING)
    private GamesType gamesType;
    @Column(name = "Price")
    private Double price;
    @Column(name = "Quantity")
    private int quantity;

    public BoardGames(String title, GamesType gamesType, Double price, int quantity) {
        this.title = title;
        this.gamesType = gamesType;
        this.price = price;
        this.quantity = quantity;
    }
}
