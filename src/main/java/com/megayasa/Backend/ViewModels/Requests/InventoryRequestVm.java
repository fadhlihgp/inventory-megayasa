package com.megayasa.Backend.ViewModels.Requests;

import com.megayasa.Backend.Annotations.Validations.MustNumber;
import com.megayasa.Backend.Annotations.Validations.NotNullProp;
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

    @MustNumber(message = "Kolom stok harus bertipe number")
    private Integer stock;
    private String type;
}
