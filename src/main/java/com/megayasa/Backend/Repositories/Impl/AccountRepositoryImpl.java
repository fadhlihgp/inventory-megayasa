package com.megayasa.Backend.Repositories.Impl;

import com.google.inject.Inject;
import com.megayasa.Backend.Models.Account;
import com.megayasa.Backend.Repositories.AccountRepository;
import com.megayasa.Backend.Repositories.QueryRepository;

import java.sql.Connection;
import java.util.List;
import java.util.Map;
import java.util.Optional;

public class AccountRepositoryImpl implements AccountRepository {
    QueryRepository<Account, String> queryRepository;

    @Inject
    public AccountRepositoryImpl( Connection connection) {
        this.queryRepository = new QueryRepositoryImpl<>(Account.class, connection);
    }

    @Override
    public List<Account> findAll() {
        return queryRepository.findAll();
    }

    @Override
    public Optional<Account> findAccountByEmail(String email) {
        return Optional.empty();
    }

    @Override
    public Optional<Account> findAccountByUsername(String username) {
        return Optional.empty();
    }

    @Override
    public Optional<Account> findByOne(Map<String, Object> filters, String where) {
        return queryRepository.findOneByFilter(filters, where);
    }

    @Override
    public Optional<Account> findAccountByEmployee_Id(String employeeId) {
        return Optional.empty();
    }

    @Override
    public void save(Account account) {
        queryRepository.save(account);
    }

    @Override
    public void update(Account account) {
        queryRepository.update(account);
    }

    @Override
    public Optional<Account> findById(String id) {
        return queryRepository.findById(id);
    }

    @Override
    public void deleteById(String id) {
        queryRepository.deleteById(id);
    }
}
