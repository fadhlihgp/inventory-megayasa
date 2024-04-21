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
import com.megayasa.Backend.Models.Role;
import com.megayasa.Backend.Repositories.AccountRepository;
import com.megayasa.Backend.Repositories.EmployeeRepository;
import com.megayasa.Backend.Services.Interfaces.AccountService;
import com.megayasa.Backend.Services.Interfaces.RoleService;
import com.megayasa.Backend.Utils.DataProperties;
import com.megayasa.Backend.ViewModels.Requests.AccountRequestVm;
import com.megayasa.Backend.ViewModels.Responses.AccountResponseVm;
import org.mindrot.jbcrypt.BCrypt;

import java.util.*;


public class AccountServiceImpl implements AccountService {
    private AccountRepository accountRepository;
    private RoleService roleService;
    private EmployeeRepository employeeRepository;
//    private final EmployeeService employeeService;


    @Inject
    public AccountServiceImpl(AccountRepository accountRepository, RoleService roleService, EmployeeRepository employeeRepository) {
        this.accountRepository = accountRepository;
//        this.employeeService = employeeService;
        this.roleService = roleService;
        this.employeeRepository = employeeRepository;
    }

    @Override
    public void createAccount(AccountRequestVm accountRequestVm) {
        ValidationUtils.validate(accountRequestVm);

        createValidation(accountRequestVm);

        if (accountRequestVm.getPassword() == null || accountRequestVm.getPassword().equals("")) {
            accountRequestVm.setPassword(DataProperties.GLOBAL_PASSWORD);
        } else {
            if (accountRequestVm.getPassword().length() <= 8) throw new WarningException("Password minimal berisi 8 karakter");
        }

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

        updateValidation(accountId, accountRequestVm);

//        If found update account
        findAccount.setUsername(accountRequestVm.getUsername());
        findAccount.setEmail(accountRequestVm.getEmail());
        findAccount.setFullName(accountRequestVm.getFullName());
        findAccount.setPhoneNumber(accountRequestVm.getPhoneNumber());
        findAccount.setIsActive(accountRequestVm.getActive());
        findAccount.setRoleId(accountRequestVm.getRoleId());
        if (!accountRequestVm.getPassword().equals("")) {
            if (accountRequestVm.getPassword().length() < 8) throw new WarningException("Jika ingin mengganti password harus lebih dari 8 karakter atau abaikan kosong untuk tidak mengganti password lama.");
            findAccount.setPassword(BCrypt.hashpw(accountRequestVm.getPassword(), BCrypt.gensalt()));
        }
//        if (accountRequestVm.getEmployeeId() != null) {
//            Employee employee = employeeService.findById(accountRequestVm.getEmployeeId());
//            Account accountByEmpId = accountRepository.findAccountByEmployee_Id(accountRequestVm.getEmployeeId())
//                    .orElse(null);
//            if ((accountByEmpId != null) &&  !findAccount.getId().equals(accountByEmpId.getId()))
//                throw new WarningException("Karyawan tidak boleh lebih dari satu akun!");
//            findAccount.setEmployeeId(accountRequestVm.getEmployeeId());
//        }
        try {
            accountRepository.update(findAccount);
            InformationDialog.successMessage("Berhasil memperbarui akun");
        } catch (Exception e) {
            throw new ErrorException(e.getMessage());
        }
    }

    @Override
    public List<AccountResponseVm> getAllAccounts() {
        List<Account> accounts = accountRepository.findAll();
        accounts.sort(Comparator.comparing(Account::getRoleId));
        List<Employee> employees = employeeRepository.findAll();
        List<Role> roles = roleService.findAll();

        return accounts.stream().map(a -> {
            Role role = roles.stream().filter(r -> r.getId().equals(a.getRoleId())).findFirst().orElse(null);
            Employee employee = employees.stream().filter(e -> e.getId().equals(a.getEmployeeId())).findFirst().orElse(null);
            return new AccountResponseVm(a.getId(), a.getFullName(), a.getUsername(),
                    a.getEmail(), a.getPhoneNumber(), a.getIsActive(), a.getLastLogin(), role, employee
                    );
        }).toList();
    }

    @Override
    public void deleteAccount(String accountId) {
        Account findAccountById = accountRepository.findById(accountId)
                .orElseThrow(() -> new NotFoundException("Akun tidak ditemukan!"));
        accountRepository.deleteById(findAccountById.getId());
        InformationDialog.deleteSuccess("Berhasil menghapus akun");
    }

    @Override
    public Account findAccountById(String accountId) {
        return accountRepository.findById(accountId)
                .orElseThrow(() -> new NotFoundException("Akun tidak ditemukan!"));
    }

    private void createValidation(AccountRequestVm accountRequestVm) {
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

        Map<String, Object> filtersByEmployee = new HashMap<>();
        filtersByUsername.put("employeeId", accountRequestVm.getEmployeeId());
        var findByEmployee = accountRepository.findByOne(filtersByEmployee,"AND" )
                .orElse(null);
        if (findByEmployee != null) throw new WarningException("Karyawan tidak boleh memiliki duplikat akun !");
    }

    private void updateValidation(String accountId, AccountRequestVm accountRequestVm) {
        Map<String, Object> filtersByEmail = new HashMap<>();
        filtersByEmail.put("email", accountRequestVm.getEmail());
        var findAccountByEmail = accountRepository.findByOne(filtersByEmail, "AND")
                .orElse(null);
        if (findAccountByEmail != null && !findAccountByEmail.getId().equals(accountId)) throw new WarningException("Email sudah digunakan, silahkan cari email lain!");

        Map<String, Object> filtersByUsername = new HashMap<>();
        filtersByUsername.put("username", accountRequestVm.getUsername());
        var findAccountByUsername = accountRepository.findByOne(filtersByUsername,"AND" )
                .orElse(null);
        if (findAccountByUsername != null && !findAccountByUsername.getId().equals(accountId)) throw new WarningException("Username sudah digunakan, silahkan cari username lain!");

        Map<String, Object> filtersByEmployee = new HashMap<>();
        filtersByUsername.put("employeeId", accountRequestVm.getEmployeeId());
        var findByEmployee = accountRepository.findByOne(filtersByEmployee,"AND" )
                .orElse(null);
        if (findByEmployee != null && !findByEmployee.getId().equals(accountId)) throw new WarningException("Karyawan tidak boleh memiliki duplikat akun !");

    }
}
