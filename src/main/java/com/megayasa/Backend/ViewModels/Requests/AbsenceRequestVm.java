package com.megayasa.Backend.ViewModels.Requests;

import com.megayasa.Backend.Annotations.Validations.NotNullProp;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AbsenceRequestVm {
    @NotNullProp(message = "Kolom karyawan tidak boleh kosong")
    private String employeeId;
    @NotNullProp(message = "Tanggal tidak boleh kosong")
    private Date date;
    @NotNullProp(message = "Keterangan tidak boleh kosong")
    private String information;
    private String note;
}
