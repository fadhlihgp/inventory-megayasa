package com.megayasa.Backend.Services.Interfaces;

import com.megayasa.Backend.Models.Account;
import com.megayasa.Backend.ViewModels.Requests.AccountRequestVm;

import java.util.List;

public interface AccountService {
    void createAccount(AccountRequestVm accountRequestVm);
    void updateAccount(String accountId, AccountRequestVm accountRequestVm);
    List<Account> getAllAccounts();
    void deleteAccount(String accountId);
}
