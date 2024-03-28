package com.megayasa.Backend.Controllers;

import com.megayasa.Backend.Services.Interfaces.LoginService;
import com.megayasa.Backend.ViewModels.Requests.LoginRequestVm;
import com.megayasa.Backend.ViewModels.Responses.LoginResponseVm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class LoginController {
    private final LoginService loginService;

    @Autowired
    public LoginController(LoginService loginService) {
        this.loginService = loginService;
    }

    public LoginResponseVm login(LoginRequestVm loginRequestVm) {
        return loginService.login(loginRequestVm);
    }
}
