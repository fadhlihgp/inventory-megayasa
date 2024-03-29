package com.megayasa.Backend.Models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Table(name = "stock_in_out")
@Entity
@Data @AllArgsConstructor @NoArgsConstructor
public class StockInOut {
    @Id
    @Column(name = "id", length = 36, nullable = false)
    private String id;

    @Column(nullable = false)
    private Date date;

    @Column(nullable = true)
    private String note;

    @Column(nullable = false)
    private Boolean status;

    @ManyToOne
    @JoinColumn(name = "inventory_id", nullable = false)
    private Inventory inventory;
}
