package com.megayasa.Backend.ViewModels.Requests;

import com.megayasa.Backend.Annotations.NotNullProp;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class LoginRequestVm {
    @NotNullProp(message = "Kolom username atau email tidak boleh kosong")
    private String username;
    @NotNullProp(message = "Kolom password tidak boleh kosong")
    private String password;
}
