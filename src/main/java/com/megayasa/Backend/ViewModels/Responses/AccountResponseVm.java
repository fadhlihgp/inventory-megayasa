package com.megayasa.Backend.ViewModels.Responses;

import com.megayasa.Backend.Models.Employee;
import com.megayasa.Backend.Models.Role;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class AccountResponseVm {
    private String id, fullName, username, email, phoneNumber;
    private Boolean isActive;
    private LocalDateTime lastLogin;
    private Role role;
    private Employee employee;
}
