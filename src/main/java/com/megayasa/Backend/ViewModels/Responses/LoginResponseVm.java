package com.megayasa.Backend.ViewModels.Responses;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class LoginResponseVm {
    private String accountId;
    private String username;
    private String email;
    private String fullName;
    private String phoneNumber;
    private String role;
    private String roleId;
}
