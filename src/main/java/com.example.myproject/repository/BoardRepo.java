package com.example.myproject.repository;

import com.example.myproject.entity.BoardEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BoardRepo extends JpaRepository<BoardEntity, Long> {
}

