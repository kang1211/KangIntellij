package com.example.jpatest.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class LoginHistoryDto {
    private long id;
    private long testMemberEntityId;
    private String ipAddr;
    private LocalDateTime loginDate;
}
