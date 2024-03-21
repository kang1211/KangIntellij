package com.example.myproject.service;

import com.example.myproject.dto.BoardDto;
import com.example.myproject.entity.BoardEntity;
import com.example.myproject.repository.BoardRepo;

import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class BoardService {

    private final BoardRepo boardRepo;

    public BoardService(BoardRepo boardRepo) {
        this.boardRepo = boardRepo;
    }

    public void saveBoard(BoardDto boardDto) {

        BoardEntity boardEntity = new BoardEntity();

        boardEntity.setName(boardDto.getName());
        boardEntity.setContent(boardDto.getContent());
        boardEntity.setRegDate(LocalDateTime.now());
        boardRepo.save(boardEntity);
    }

    public List<BoardEntity> getAllBoards() {
        return boardRepo.findAll();
    }

    public void deleteBoardById(Long id) {
        boardRepo.deleteById(id);
    }
}