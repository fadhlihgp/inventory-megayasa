package com.megayasa.Backend.Services;

import com.megayasa.Backend.Annotations.Util.ValidationUtils;
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
import jakarta.transaction.Transactional;
import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@Transactional
public class AccountServiceImpl implements AccountService {
    private final AccountRepository accountRepository;
    private final RoleService roleService;
    private final EmployeeService employeeService;


    @Autowired
    public AccountServiceImpl(AccountRepository accountRepository, RoleService roleService, EmployeeService employeeService) {
        this.accountRepository = accountRepository;
        this.roleService = roleService;
        this.employeeService = employeeService;
    }

    @Override
    public void createAccount(AccountRequestVm accountRequestVm) {
        ValidationUtils.validate(accountRequestVm);
        var findAccountByEmail = accountRepository.findAccountByEmail(accountRequestVm.getEmail())
                .orElse(null);
        if (findAccountByEmail != null) throw new WarningException("Email sudah digunakan, silahkan cari email lain!");

        var findAccountByUsername = accountRepository.findAccountByUsername(accountRequestVm.getUsername())
                .orElse(null);
        if (findAccountByUsername != null) throw new WarningException("Username sudah digunakan, silahkan cari username lain!");

        Account account = new Account();
        account.setId(UUID.randomUUID().toString());
        account.setIsActive(accountRequestVm.getIsActive() == null || accountRequestVm.getIsActive());
        account.setRole(roleService.findById(accountRequestVm.getRoleId()));
        account.setUsername(accountRequestVm.getUsername());
        account.setEmail(accountRequestVm.getEmail());
        account.setFullName(accountRequestVm.getFullName());
        account.setPassword(BCrypt.hashpw(accountRequestVm.getPassword(), BCrypt.gensalt()));
        account.setPhoneNumber(accountRequestVm.getPhoneNumber());
        if (accountRequestVm.getEmployeeId() != null) {
            Employee employee = employeeService.findById(accountRequestVm.getEmployeeId());
            Account accountByEmpId = accountRepository.findAccountByEmployee_Id(accountRequestVm.getEmployeeId())
                    .orElse(null);
            if (accountByEmpId != null) throw new WarningException("Karyawan tidak boleh lebih dari satu akun!");
            account.setEmployee(employee);
        }
        try {
            accountRepository.save(account);
            InformationDialog.successMessage("Berhasil menambah data akun");
        } catch (Exception e) {
            throw new ErrorException(e.getMessage());
        }
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
        findAccount.setIsActive(accountRequestVm.getIsActive());
        findAccount.setRole(roleService.findById(accountRequestVm.getRoleId()));
        if (accountRequestVm.getEmployeeId() != null) {
            Employee employee = employeeService.findById(accountRequestVm.getEmployeeId());
            Account accountByEmpId = accountRepository.findAccountByEmployee_Id(accountRequestVm.getEmployeeId())
                    .orElse(null);
            if ((accountByEmpId != null) &&  !findAccount.getId().equals(accountByEmpId.getId()))
                throw new WarningException("Karyawan tidak boleh lebih dari satu akun!");
            findAccount.setEmployee(employee);
        }
        accountRepository.save(findAccount);
        InformationDialog.successMessage("Berhasil memperbarui akun");
    }

    @Override
    public List<Account> getAllAccounts() {
        return accountRepository.findAll(Sort.by(Sort.Order.asc("Role")));
    }

    @Override
    public void deleteAccount(String accountId) {
        Account findAccountById = accountRepository.findById(accountId)
                .orElseThrow(() -> new NotFoundException("Akun tidak ditemukan!"));
        accountRepository.delete(findAccountById);
        InformationDialog.deleteSuccess("Berhasil menghapus akun");
    }
}
