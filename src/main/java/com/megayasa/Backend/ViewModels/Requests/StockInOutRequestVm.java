package com.megayasa.Backend.ViewModels.Requests;

import com.megayasa.Backend.Annotations.Validations.NotNullProp;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class StockInOutRequestVm {
    @NotNullProp(message = "Barang tidak boleh kosong")
    private String inventoryId;

    @NotNullProp(message = "Tanggal tidak boleh kosong")
    private Date date;

    @NotNullProp(message = "Jumlah barang tidak boleh kosong")
    private Integer amount;

    @NotNullProp(message = "Status barang tidak boleh kosong")
    private Boolean status;
    private String note;
}
