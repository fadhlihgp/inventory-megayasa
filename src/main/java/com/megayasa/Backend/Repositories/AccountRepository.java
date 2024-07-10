package com.megayasa.Backend.Repositories;

import com.megayasa.Backend.Models.Account;
import java.util.List;
import java.util.Map;
import java.util.Optional;

public interface AccountRepository {
    List<Account> findAll();
    Optional<Account> findAccountByEmail(String email);
    Optional<Account> findAccountByUsername(String username);
    Optional<Account> findByOne(Map<String, Object> filters, String where);
    Optional<Account> findAccountByEmployee_Id(String employeeId);
    void save(Account account);
    void update(Account account);
    Optional<Account> findById(String id);
    void deleteById(String id);
}
