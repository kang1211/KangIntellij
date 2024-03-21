package com.example.myproject.control;

import com.example.myproject.dto.BoardDto;

import com.example.myproject.entity.BoardEntity;
import com.example.myproject.service.BoardService;

import org.springframework.stereotype.Controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class MainController {

    private final BoardService boardService;

    @GetMapping("/")
    public String index(Model model){
        BoardDto boardDto = new BoardDto();
        model.addAttribute("boardDto", boardDto);
        model.addAttribute("boardEntity", new BoardEntity()); // 추가
        List<BoardEntity> boardList = boardService.getAllBoards(); // 게시글 목록 가져오기
        model.addAttribute("boardList", boardList);
        return "main";
    }

    public MainController(BoardService boardService) {
        this.boardService = boardService;
    }

    @PostMapping("/write")
    public String write(BoardDto boardDto) {
        boardService.saveBoard(boardDto);
        return "redirect:/";
    }

    @PostMapping("/delete")
    public String deleteBoard(@RequestParam("id") Long id) {
        boardService.deleteBoardById(id);
        return "redirect:/";
    }

}
