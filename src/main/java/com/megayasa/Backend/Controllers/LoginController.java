package com.megayasa.Backend.Controllers;

import com.google.inject.Inject;
import com.megayasa.Backend.Services.Interfaces.LoginService;
import com.megayasa.Backend.ViewModels.Requests.LoginRequestVm;
import com.megayasa.Backend.ViewModels.Responses.LoginResponseVm;
public class LoginController {
    private final LoginService loginService;

    @Inject
    public LoginController(LoginService loginService) {
        this.loginService = loginService;
    }

    public LoginResponseVm login(LoginRequestVm loginRequestVm) {
        return loginService.login(loginRequestVm);
    }
}
