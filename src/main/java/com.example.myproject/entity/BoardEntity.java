package com.example.myproject.entity;

import com.example.myproject.dto.BoardDto;
import lombok.Getter;
import lombok.Setter;
import org.modelmapper.ModelMapper;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Setter
@Getter
public class BoardEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column
    private String name;

    @Column
    private String content;

    @Column
    private LocalDateTime regDate;

    public void updateBoard(BoardDto boardDto){
        this.name = boardDto.getName();
        this.content = boardDto.getContent();
    }
}
