package com.example.jpatest.dto;

import lombok.Data;

@Data
public class ItemDto {
    private Long id;
    private String itemName;
    private String brand;
    private String cpu;
    private float inch;
    private int ram;
    private String as;
}
