package com.megayasa.Backend.Models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Table(name = "inventory")
@Entity
@Data @AllArgsConstructor @NoArgsConstructor
public class Inventory {
    @Id
    @Column(name = "id", length = 36, nullable = false)
    private String id;

    @Column(length = 255, nullable = false)
    private String name;

    @Column(length = 255, nullable = false, unique = true)
    private String code;

    @Column(nullable = false)
    private Integer stock;

    @Column(nullable = true, length = 255)
    private String type;
}
