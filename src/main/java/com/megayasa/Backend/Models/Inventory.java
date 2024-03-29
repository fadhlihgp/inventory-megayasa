package com.megayasa.Backend.Models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Table(name = "inventory")
@Entity
@Data @AllArgsConstructor @NoArgsConstructor
public class Inventory {
    @Id
    @Column(name = "id", length = 36, nullable = false)
    private String id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false, unique = true)
    private String code;

    @Column(nullable = false)
    private Integer stock;

    private String type;

    @OneToMany(mappedBy = "inventory", cascade = CascadeType.ALL)
    private List<StockInOut> stockInOuts;
}
