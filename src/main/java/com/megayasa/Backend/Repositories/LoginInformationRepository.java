package com.megayasa.Backend.Repositories;

import com.megayasa.Backend.Models.LoginInformation;

public interface LoginInformationRepository {

    void createLoginInformation(LoginInformation loginInformation);
    void deleteLoginInformation();
    LoginInformation currentLogin();
}
