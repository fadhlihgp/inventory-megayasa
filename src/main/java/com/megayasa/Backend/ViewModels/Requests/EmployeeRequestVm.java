package com.megayasa.Backend.ViewModels.Requests;

import com.megayasa.Backend.Annotations.NotNullProp;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EmployeeRequestVm {
    @NotNullProp(message = "Id karyawan tidak boleh kosong")
    private String employeeId;

    private String identityNumber;

    @NotNullProp(message = "Nama lengkap tidak boleh kosong")
    private String fullName;

    @NotNullProp(message = "Tanggal lahir tidak boleh kosong")
    private Date birthDate;

    @NotNullProp(message = "Alamat tidak boleh kosong")
    private String address;

    @NotNullProp(message = "Jenis kelamin tidak boleh kosong")
    private String gender;

    private String phoneNumber;

    @NotNullProp(message = "Jabatan tidak boleh kosong")
    private String positionId;

    private Boolean isActive;
}
