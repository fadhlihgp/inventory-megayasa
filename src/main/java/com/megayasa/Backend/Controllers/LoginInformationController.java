package com.megayasa.Backend.Controllers;

import com.google.inject.Inject;
import com.megayasa.Backend.Models.LoginInformation;
import com.megayasa.Backend.Services.Interfaces.LoginInformationService;

public class LoginInformationController {
    LoginInformationService loginInformationService;

    @Inject
    public LoginInformationController(LoginInformationService loginInformationService) {
        this.loginInformationService = loginInformationService;
    }

    public LoginInformation currentLogin() {
        return loginInformationService.currentLogin();
    }

    public Boolean deleteLoginInformation() {
        return loginInformationService.deleteLoginInformation();
    }
}
