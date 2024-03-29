package com.megayasa.Backend.ViewModels.Requests;

import com.megayasa.Backend.Annotations.NotNullProp;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class InventoryRequestVm {
    @NotNullProp(message = "Kode brang tidak boleh kosong")
    private String code;

    @NotNullProp(message = "Nama barang tidak boleh kosong")
    private String name;

    private Integer stock;
    private String type;
}
