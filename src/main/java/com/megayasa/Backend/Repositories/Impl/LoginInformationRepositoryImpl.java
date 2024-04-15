package com.megayasa.Backend.Repositories.Impl;

import com.google.inject.Inject;
import com.megayasa.Backend.Models.LoginInformation;
import com.megayasa.Backend.Repositories.LoginInformationRepository;
import com.megayasa.Backend.Repositories.QueryRepository;

import java.sql.Connection;
import java.util.List;

public class LoginInformationRepositoryImpl implements LoginInformationRepository {
    QueryRepository<LoginInformation, String> queryRepository;

    @Inject
    public LoginInformationRepositoryImpl(Connection connection) {
        this.queryRepository = new QueryRepositoryImpl<>(LoginInformation.class, connection);
    }

    @Override
    public void createLoginInformation(LoginInformation loginInformation) {
        queryRepository.save(loginInformation);
    }

    @Override
    public void deleteLoginInformation() {
        queryRepository.deleteByClass(currentLogin());
    }

    @Override
    public LoginInformation currentLogin() {
        List<LoginInformation> all = queryRepository.findAll();
        if (all.size() < 1) {
            return null;
        }
        return all.get(0);
    }

}
