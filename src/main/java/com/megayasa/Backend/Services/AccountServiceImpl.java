package com.megayasa.Backend.Services;

import com.google.inject.Inject;
import com.megayasa.Backend.Annotations.Util.ValidationUtils;
import com.megayasa.Backend.Context.TransactionUtil;
import com.megayasa.Backend.Dialogs.InformationDialog;
import com.megayasa.Backend.Exceptions.ErrorException;
import com.megayasa.Backend.Exceptions.NotFoundException;
import com.megayasa.Backend.Exceptions.WarningException;
import com.megayasa.Backend.Models.Account;
import com.megayasa.Backend.Models.Employee;
import com.megayasa.Backend.Repositories.AccountRepository;
import com.megayasa.Backend.Services.Interfaces.AccountService;
import com.megayasa.Backend.Services.Interfaces.EmployeeService;
import com.megayasa.Backend.Services.Interfaces.RoleService;
import com.megayasa.Backend.ViewModels.Requests.AccountRequestVm;
import org.mindrot.jbcrypt.BCrypt;

import java.util.*;


public class AccountServiceImpl implements AccountService {
    private AccountRepository accountRepository;
//    private final EmployeeService employeeService;


    @Inject
    public AccountServiceImpl(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
//        this.employeeService = employeeService;
    }

    @Override
    public void createAccount(AccountRequestVm accountRequestVm) {
        ValidationUtils.validate(accountRequestVm);

        Map<String, Object> filtersByEmail = new HashMap<>();
        filtersByEmail.put("email", accountRequestVm.getEmail());
        var findAccountByEmail = accountRepository.findByOne(filtersByEmail, "AND")
                .orElse(null);
        if (findAccountByEmail != null) throw new WarningException("Email sudah digunakan, silahkan cari email lain!");

        Map<String, Object> filtersByUsername = new HashMap<>();
        filtersByUsername.put("username", accountRequestVm.getUsername());
        var findAccountByUsername = accountRepository.findByOne(filtersByUsername,"AND" )
                .orElse(null);
        if (findAccountByUsername != null) throw new WarningException("Username sudah digunakan, silahkan cari username lain!");

        Account account = new Account();
        account.setId(UUID.randomUUID().toString());
        account.setIsActive(accountRequestVm.getActive() == null || accountRequestVm.getActive());
        account.setRoleId(accountRequestVm.getRoleId());
        account.setUsername(accountRequestVm.getUsername());
        account.setEmail(accountRequestVm.getEmail());
        account.setFullName(accountRequestVm.getFullName());
        account.setPassword(BCrypt.hashpw(accountRequestVm.getPassword(), BCrypt.gensalt()));
        account.setPhoneNumber(accountRequestVm.getPhoneNumber());
        if (accountRequestVm.getEmployeeId() != null) {
//            Employee employee = employeeService.findById(accountRequestVm.getEmployeeId());
//            Account accountByEmpId = accountRepository.findAccountByEmployee_Id(accountRequestVm.getEmployeeId())
//                    .orElse(null);
//            if (accountByEmpId != null) throw new WarningException("Karyawan tidak boleh lebih dari satu akun!");
//            account.setEmployee(employee);
            account.setEmployeeId(accountRequestVm.getEmployeeId());
        }
        TransactionUtil.performTransaction(() -> {
            accountRepository.save(account);
            InformationDialog.successMessage("Berhasil menambah akun");
        });
    }

    @Override
    public void updateAccount(String accountId, AccountRequestVm accountRequestVm) {
        ValidationUtils.validate(accountRequestVm);
        Account findAccount = accountRepository.findById(accountId)
                .orElseThrow(() -> new NotFoundException("Akun tidak ditemukan"));


//        If found update account
        findAccount.setUsername(accountRequestVm.getUsername());
        findAccount.setEmail(accountRequestVm.getEmail());
        findAccount.setFullName(accountRequestVm.getFullName());
        findAccount.setPhoneNumber(accountRequestVm.getPhoneNumber());
        findAccount.setIsActive(accountRequestVm.getActive());
        findAccount.setRoleId(accountRequestVm.getRoleId());
//        if (accountRequestVm.getEmployeeId() != null) {
//            Employee employee = employeeService.findById(accountRequestVm.getEmployeeId());
//            Account accountByEmpId = accountRepository.findAccountByEmployee_Id(accountRequestVm.getEmployeeId())
//                    .orElse(null);
//            if ((accountByEmpId != null) &&  !findAccount.getId().equals(accountByEmpId.getId()))
//                throw new WarningException("Karyawan tidak boleh lebih dari satu akun!");
//            findAccount.setEmployeeId(accountRequestVm.getEmployeeId());
//        }
        accountRepository.save(findAccount);
        InformationDialog.successMessage("Berhasil memperbarui akun");
    }

    @Override
    public List<Account> getAllAccounts() {
//        return accountRepository.findAll(Sort.by(Sort.Order.asc("Role")));
        return new ArrayList<Account>();
    }

    @Override
    public void deleteAccount(String accountId) {
        Account findAccountById = accountRepository.findById(accountId)
                .orElseThrow(() -> new NotFoundException("Akun tidak ditemukan!"));
        accountRepository.deleteById(findAccountById.getId());
        InformationDialog.deleteSuccess("Berhasil menghapus akun");
    }
}
