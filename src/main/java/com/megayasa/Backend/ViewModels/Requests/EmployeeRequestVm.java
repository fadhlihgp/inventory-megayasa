package com.megayasa.Backend.ViewModels.Requests;

import com.megayasa.Backend.Annotations.Validations.LengthConstraint;
import com.megayasa.Backend.Annotations.Validations.MustNumber;
import com.megayasa.Backend.Annotations.Validations.NotNullProp;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EmployeeRequestVm {
    @NotNullProp(message = "Id karyawan tidak boleh kosong")
    private String employeeId;

    @NotNullProp(message = "Nomor identitas karyawan tidak boleh kosong")
    @MustNumber(message = "Nomor identitas karyawan harus berisikan angka")
    @LengthConstraint(minLength = 16, maxLength = 16, message = "Nomor identitas karyawan harus berisikan 16 karakter")
    private String identityNumber;

    @NotNullProp(message = "Nama lengkap tidak boleh kosong")
    private String fullName;

    @NotNullProp(message = "Tanggal lahir tidak boleh kosong")
    private Date birthDate;

    @NotNullProp(message = "Alamat tidak boleh kosong")
    private String address;

    @NotNullProp(message = "Jenis kelamin tidak boleh kosong")
    private String gender;

    @MustNumber(message = "Nomor ponsel harus berisikan tipe data number")
    private String phoneNumber;

    @NotNullProp(message = "Jabatan tidak boleh kosong")
    private String positionId;

    private Boolean isActive;
}
