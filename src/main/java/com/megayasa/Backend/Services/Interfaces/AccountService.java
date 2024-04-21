package com.megayasa.Backend.Services.Interfaces;

import com.megayasa.Backend.Models.Account;
import com.megayasa.Backend.ViewModels.Requests.AccountRequestVm;
import com.megayasa.Backend.ViewModels.Responses.AccountResponseVm;

import javax.xml.stream.util.StreamReaderDelegate;
import java.util.List;

public interface AccountService {
    void createAccount(AccountRequestVm accountRequestVm);
    void updateAccount(String accountId, AccountRequestVm accountRequestVm);
    List<AccountResponseVm> getAllAccounts();
    void deleteAccount(String accountId);
    Account findAccountById(String accountId);
}
