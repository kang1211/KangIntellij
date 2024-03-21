package com.example.myproject.dto;

import com.example.myproject.entity.BoardEntity;
import lombok.Data;
import org.modelmapper.ModelMapper;

import java.time.LocalDateTime;

@Data
public class BoardDto {
    private Long id;
    private String name;
    private String content;
    private LocalDateTime regDate;
}
