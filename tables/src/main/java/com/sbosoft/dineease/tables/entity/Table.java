package com.sbosoft.dineease.tables.entity;

import com.sbosoft.dineease.tables.pojo.Utils;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import java.util.List;

@Entity
@Getter @Setter @ToString(includeFieldNames = true)
public class Table {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String name;

    @Column(nullable = false, columnDefinition = "integer default 2")
    private int placeNumber; //number of person each table

    @Column(nullable = false, columnDefinition = "integer default 1")
    private int stock;

    @Column(nullable = true)
    private String brand;

    private Utils.MaterialType materialType = Utils.MaterialType.WOOD;

    @Column(nullable = false, columnDefinition = "boolean default true")
    private boolean isAvailable;

    @OneToMany(mappedBy = "table")
    @OnDelete(action = OnDeleteAction.CASCADE)
    private List<Chair> chairs;

    public Table(){}

    public Table(String name, int placeNumber, int stock, String brand, Utils.MaterialType materialType, boolean isAvailable, List<Chair> chairs) {
        this.name = name;
        this.placeNumber = placeNumber;
        this.stock = stock;
        this.brand = brand;
        this.materialType = materialType;
        this.isAvailable = isAvailable;
        this.chairs = chairs;
    }
}
