package com.megayasa.Backend.Controllers;

import com.megayasa.Backend.Models.Account;
import com.megayasa.Backend.Services.Interfaces.AccountService;
import com.megayasa.Backend.ViewModels.Requests.AccountRequestVm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
public class AccountController {
    private final AccountService accountService;

    @Autowired
    public AccountController(AccountService accountService) {
        this.accountService = accountService;
    }

    public void createAccount(AccountRequestVm accountRequestVm){
        accountService.createAccount(accountRequestVm);
    }

    public void updateAccount(String accountId, AccountRequestVm accountRequestVm){
        accountService.updateAccount(accountId, accountRequestVm);
    }

    public List<Account> getAllAccounts() {
        return accountService.getAllAccounts();
    }

    public void deleteAccount(String accountId) {
        accountService.deleteAccount(accountId);
    }
}
