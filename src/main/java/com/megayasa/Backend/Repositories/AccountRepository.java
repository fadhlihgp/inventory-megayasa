package com.megayasa.Backend.Repositories;

import com.megayasa.Backend.Models.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AccountRepository extends JpaRepository<Account, String> {
    Optional<Account> findAccountByEmail(String email);
    Optional<Account> findAccountByUsername(String username);
    Optional<Account> findAccountByEmailOrUsername(String email, String username);
    Optional<Account> findAccountByEmployee_Id(String employeeId);
}
