package com.example.jpatest.entity;

import com.example.jpatest.dto.ItemDto;
import lombok.Getter;
import lombok.Setter;
import org.modelmapper.ModelMapper;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Getter
@Setter
public class Item {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 50)
    private String itemName;
    @Column
    private String brand;
    @Column
    private String cpu;
    @Column
    private float inch;
    @Column
    private int ram;
    @Column(columnDefinition = "VARCHAR(255) Default '프리도스'")
    private String os;
    @Column
    private int cost;
    @Column
    private LocalDateTime regDate;
    @Column
    private String seller;

    @OneToOne(mappedBy = "item")
    private ItemImg itemImg;

    public void updateItem(ItemDto itemDto){
        this.cost = itemDto.getCost();
        this.cpu = itemDto.getCpu();
        this.brand = itemDto.getBrand();
        this.inch = itemDto.getInch();
        this.ram = itemDto.getRam();
        this.os = itemDto.getOs();
        this.itemName = itemDto.getItemName();
    }

    private static ModelMapper modelMapper=new ModelMapper();

    public static Item of(ItemDto itemDto){
        itemDto.setRegDate(LocalDateTime.now());
        return modelMapper.map(itemDto, Item.class);
    }
}
