package com.megayasa.Backend.Models;

import com.megayasa.Backend.Annotations.Db.Column;
import com.megayasa.Backend.Annotations.Db.Id;
import com.megayasa.Backend.Annotations.Db.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Table(name = "stock_in_out")
@Data @AllArgsConstructor @NoArgsConstructor
public class StockInOut {
    @Id
    @Column(name = "id")
    private String id;

    @Column(name = "amount")
    private Integer amount;

    @Column(name = "date")
    private Date date;

    @Column(name = "note")
    private String note;

    @Column(name = "status")
    private Boolean status;

    @Column(name = "inventory_id")
    private String inventoryId;
}
