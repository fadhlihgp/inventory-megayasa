package com.megayasa.Backend.Services;

import com.google.inject.Inject;
import com.megayasa.Backend.Annotations.Util.ValidationUtils;
import com.megayasa.Backend.Context.TransactionUtil;
import com.megayasa.Backend.Exceptions.UnauthorizedException;
import com.megayasa.Backend.Models.Account;
import com.megayasa.Backend.Models.LoginInformation;
import com.megayasa.Backend.Models.Role;
import com.megayasa.Backend.Repositories.AccountRepository;
import com.megayasa.Backend.Services.Interfaces.LoginInformationService;
import com.megayasa.Backend.Services.Interfaces.LoginService;
import com.megayasa.Backend.Services.Interfaces.RoleService;
import com.megayasa.Backend.Utils.DataProperties;
import com.megayasa.Backend.ViewModels.Requests.LoginRequestVm;
import com.megayasa.Backend.ViewModels.Responses.LoginResponseVm;
import org.mindrot.jbcrypt.BCrypt;


import java.sql.Date;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.temporal.ChronoUnit;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class LoginServiceImpl implements LoginService {
    private final AccountRepository accountRepository;
    private final LoginInformationService loginInformationService;
    private final RoleService roleService;

    @Inject
    public LoginServiceImpl(AccountRepository accountRepository, LoginInformationService loginInformationService, RoleService roleService) {
        this.accountRepository = accountRepository;
        this.loginInformationService = loginInformationService;
        this.roleService = roleService;
    }

    public LoginResponseVm login(LoginRequestVm loginRequestVm) {
        ValidationUtils.validate(loginRequestVm);

        Map<String, Object> filters = new HashMap<>();
        filters.put("username", loginRequestVm.getUsername());
        filters.put("email", loginRequestVm.getUsername());
        Account findAccount = accountRepository.findByOne(filters, "OR").orElse(null);
//        If not found will return exception
        if (findAccount == null) throw new UnauthorizedException("Username atau Password salah");

        if (!findAccount.getIsActive()) throw new UnauthorizedException("Akun anda tidak aktif, silahkan hubungi root akun untuk bantuan");

//        If find will be validated by password
        boolean isValid = BCrypt.checkpw(loginRequestVm.getPassword(), findAccount.getPassword());
//        if not valid will return exception
        if(!isValid) throw new UnauthorizedException("Username atau Password salah");

//        If find will update last login and return response
        findAccount.setLastLogin(LocalDateTime.now(ZoneId.of("Asia/Jakarta")));

        Role roleById = roleService.findById(findAccount.getRoleId());

        // Add to information login
        LoginInformation loginInformation = new LoginInformation();
        loginInformation.setId(UUID.randomUUID().toString());
        loginInformation.setEmail(findAccount.getEmail());
        loginInformation.setFullName(findAccount.getFullName());
        loginInformation.setRole(roleById.getName());
        loginInformation.setRoleId(findAccount.getRoleId());
        loginInformation.setAccountId(findAccount.getId());
        loginInformation.setUsername(findAccount.getUsername());
        loginInformation.setPhoneNumber(findAccount.getPhoneNumber());
        loginInformation.setExpiredLogin(LocalDateTime.now(ZoneId.of("Asia/Jakarta")).plus(DataProperties.EXPIRED_LOGIN_TIMEOUT, ChronoUnit.HOURS));

        TransactionUtil.performTransaction(() -> {
            accountRepository.update(findAccount);
            loginInformationService.createLoginInformation(loginInformation);
        });

        return new LoginResponseVm(
                findAccount.getId(), findAccount.getUsername(), findAccount.getEmail(),
                findAccount.getFullName(), findAccount.getPhoneNumber(), roleById.getName(),
                findAccount.getRoleId()
        );
    }
}
