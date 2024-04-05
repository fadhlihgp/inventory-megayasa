package com.megayasa.Backend.ViewModels.Requests;

import com.megayasa.Backend.Annotations.Validations.NotNullProp;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

public class LoginRequestVm {
    public LoginRequestVm() {
    }

    public LoginRequestVm(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @NotNullProp(message = "Kolom username atau email tidak boleh kosong")
    private String username;
    @NotNullProp(message = "Kolom password tidak boleh kosong")
    private String password;
}
