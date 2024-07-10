package com.megayasa.Backend.Services;

import com.google.inject.Inject;
import com.megayasa.Backend.Models.LoginInformation;
import com.megayasa.Backend.Repositories.LoginInformationRepository;
import com.megayasa.Backend.Services.Interfaces.LoginInformationService;

import java.time.LocalDateTime;

public class LoginInformationServiceImpl implements LoginInformationService {
    LoginInformationRepository loginInformationRepository;

    @Inject
    public LoginInformationServiceImpl(LoginInformationRepository loginInformationRepository) {
        this.loginInformationRepository = loginInformationRepository;
    }

    @Override
    public void createLoginInformation(LoginInformation loginInformation) {
        loginInformationRepository.createLoginInformation(loginInformation);
    }

    @Override
    public Boolean deleteLoginInformation() {
        try {
            if (currentLogin() != null) {
                loginInformationRepository.deleteLoginInformation();
            }
            return true;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return false;
        }
    }

    @Override
    public LoginInformation currentLogin() {
        LoginInformation loginInformation = loginInformationRepository.currentLogin();

        if (loginInformation != null) {
            if (loginInformation.getExpiredLogin().isBefore(LocalDateTime.now())) {
                loginInformationRepository.deleteLoginInformation();
                return null;
            }
            return loginInformation;
        }

        return null;
    }
}
