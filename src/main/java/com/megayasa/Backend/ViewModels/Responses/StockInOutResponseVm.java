package com.megayasa.Backend.ViewModels.Responses;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class StockInOutResponseVm {
    private String id;
    private Date date;
    private Integer amount;
    private Boolean status;
    private String note;
    private String inventoryId;
    private String inventoryName;
    private String inventoryCode;
}
