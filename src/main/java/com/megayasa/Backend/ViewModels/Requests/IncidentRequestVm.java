package com.megayasa.Backend.ViewModels.Requests;

import com.megayasa.Backend.Annotations.NotNullProp;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class IncidentRequestVm {
    @NotNullProp(message = "Kolom judul tidak boleh kosong")
    private String title;

    @NotNullProp(message = "Kolom deskripsi tidak boleh kosong")
    private String description;

    @NotNullProp(message = "Tanggal tidak boleh kosong")
    private Date date;

    private String pictureUrl;
}
