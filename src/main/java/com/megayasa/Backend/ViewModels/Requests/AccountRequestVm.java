package com.megayasa.Backend.ViewModels.Requests;

import com.megayasa.Backend.Annotations.Validations.MustEmail;
import com.megayasa.Backend.Annotations.Validations.NotNullProp;

public class AccountRequestVm {
    public AccountRequestVm(String fullName, String username, String email, String password, String phoneNumber, Boolean isActive, String roleId, String employeeId) {
        this.fullName = fullName;
        this.username = username;
        this.email = email;
        this.password = password;
        this.phoneNumber = phoneNumber;
        this.isActive = isActive;
        this.roleId = roleId;
        this.employeeId = employeeId;
    }

    public AccountRequestVm() {
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public Boolean getActive() {
        return isActive;
    }

    public void setActive(Boolean active) {
        isActive = active;
    }

    public String getRoleId() {
        return roleId;
    }

    public void setRoleId(String roleId) {
        this.roleId = roleId;
    }

    public String getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(String employeeId) {
        this.employeeId = employeeId;
    }

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
