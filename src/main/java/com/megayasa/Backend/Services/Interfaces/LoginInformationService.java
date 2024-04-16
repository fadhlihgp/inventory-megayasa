package com.megayasa.Backend.Services.Interfaces;

import com.megayasa.Backend.Models.LoginInformation;

public interface LoginInformationService {
    void createLoginInformation(LoginInformation loginInformation);
    Boolean deleteLoginInformation();
    LoginInformation currentLogin();
}
