package com.example.springpracticeproject_boardgames.repository;

import com.example.springpracticeproject_boardgames.entity.BoardGame;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BoardGameRepository extends JpaRepository<BoardGame, Integer> {
}
