package com.example.springpracticeproject_boardgames.service;

import com.example.springpracticeproject_boardgames.dto.BoardGameDTO;
import com.example.springpracticeproject_boardgames.entity.BoardGame;
import com.example.springpracticeproject_boardgames.enums.GameType;
import com.example.springpracticeproject_boardgames.mapper.BoardGameMapper;
import com.example.springpracticeproject_boardgames.repository.BoardGameRepository;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.List;

@Service
public class BoardGameService {


    public static final String UPLOAD_LOCATION = System.getProperty("user.dir")  // daje lokalizacje projekty
            + "\\upload" + File.separator;
    private BoardGameRepository boardGameRepository;
     private BoardGameMapper mapper;

    public BoardGameService(BoardGameRepository boardGameRepository, BoardGameMapper mapper) {
        this.boardGameRepository = boardGameRepository;
        this.mapper = mapper;
    }


//    public void addBoardGame(BoardGameDTO boardGameDTO){
//        try {
//            MultipartFile fileToLoad = boardGameDTO.getFile();
//
//            if (fileToLoad.isEmpty()) {
//                throw new IllegalArgumentException("Brak załącznika!");
//            }
//
//            String fileName = StringUtils.cleanPath(fileToLoad.getOriginalFilename());
//
//            BoardGame boardGame = mapper.mapToEntity(boardGameDTO);
//        boardGameRepository.save(boardGame);
//
//            File destinationFile = new File(UPLOAD_LOCATION + boardGame.getFileNameWithId());
//            fileToLoad.transferTo(destinationFile);
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//
//    }

    public void addBoardGame(BoardGameDTO boardGameDTO){
            BoardGame boardGame = new BoardGame(boardGameDTO.getTitle(), GameType.valueOf(boardGameDTO.getGameType()),boardGameDTO.getPrice(),
                    boardGameDTO.getQuantity());
            boardGameRepository.save(boardGame);
    }

     public List<BoardGameDTO> getBoardGames (){
        return boardGameRepository.findAll().stream()
                .map(boardGame -> new BoardGameDTO(boardGame.getBoardGameId(), boardGame.getTitle(),boardGame.getGameType().toString(),
                        boardGame.getPrice(), boardGame.getQuantity(), boardGame.getFileName())).toList();
     }

     public BoardGameDTO findById(int boardGameId){
        BoardGame boardGame = boardGameRepository.findById(boardGameId).orElse(null);
//        BoardGameDTO boardGameDTO = new BoardGameDTO(boardGame.getBoardGameId(), boardGame.getTitle(), boardGame.getGameType().toString(),
//                boardGame.getPrice(), boardGame.getQuantity(), null, boardGame.getFileName());
         BoardGameDTO boardGameDTO = mapper.mapToDto(boardGame);
        return boardGameDTO;
     }

}
