package com.megayasa.Backend.ViewModels.Requests;

import com.megayasa.Backend.Annotations.MustEmail;
import com.megayasa.Backend.Annotations.NotNullProp;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AccountRequestVm {
    @NotNullProp(message = "Kolom nama lengkap tidak boleh kosong")
    private String fullName;

    @NotNullProp(message = "Kolom username tidak boleh kosong")
    private String username;

    @NotNullProp(message = "Kolom email tidak boleh kosong")
    @MustEmail
    private String email;
    private String password;
    private String phoneNumber;
    private Boolean isActive;

    @NotNullProp(message = "Role tidak boleh kosong")
    private String roleId;
    private String employeeId;
}
