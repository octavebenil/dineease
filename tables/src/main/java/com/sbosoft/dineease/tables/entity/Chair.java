package com.sbosoft.dineease.tables.entity;

import com.sbosoft.dineease.tables.pojo.Utils;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter @Setter @ToString(includeFieldNames = true)
public class Chair {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private int number;

    @Column(nullable = false, columnDefinition = "integer default 1")
    private int stock;

    @Column(nullable = true)
    private String brand;

    private Utils.MaterialType materialType = Utils.MaterialType.WOOD;

    @Column(nullable = false, columnDefinition = "boolean default true")
    private boolean isAvailable;

    public Chair(){}

    public Chair(int number, int stock, String brand, Utils.MaterialType materialType, boolean isAvailable) {
        this.number = number;
        this.stock = stock;
        this.brand = brand;
        this.materialType = materialType;
        this.isAvailable = isAvailable;
    }
}
