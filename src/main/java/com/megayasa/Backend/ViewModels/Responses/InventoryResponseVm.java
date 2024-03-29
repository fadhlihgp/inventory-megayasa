package com.megayasa.Backend.ViewModels.Responses;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class InventoryResponseVm {
    private String id;
    private String name;
    private String code;
    private Integer stock;
    private String type;

}
