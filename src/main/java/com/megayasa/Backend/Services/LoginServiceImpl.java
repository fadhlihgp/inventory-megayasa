package com.megayasa.Backend.Services;

import com.megayasa.Backend.Annotations.Util.ValidationUtils;
import com.megayasa.Backend.Exceptions.UnauthorizedException;
import com.megayasa.Backend.Models.Account;
import com.megayasa.Backend.Repositories.AccountRepository;
import com.megayasa.Backend.Services.Interfaces.LoginService;
import com.megayasa.Backend.ViewModels.Requests.LoginRequestVm;
import com.megayasa.Backend.ViewModels.Responses.LoginResponseVm;
import jakarta.transaction.Transactional;
import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.Optional;

@Service
@Transactional
public class LoginServiceImpl implements LoginService {
    private AccountRepository accountRepository;

    @Autowired
    public LoginServiceImpl(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    public LoginResponseVm login(LoginRequestVm loginRequestVm) {
        ValidationUtils.validate(loginRequestVm);

//        Find account by username or email
         Account findAccount = accountRepository.findAccountByEmailOrUsername(loginRequestVm.getUsername(), loginRequestVm.getUsername())
                 .orElse(null);
//        If not found will return exception
        if (findAccount == null) throw new UnauthorizedException("Username atau Password salah");

        if (!findAccount.getIsActive()) throw new UnauthorizedException("Akun anda tidak aktif, silahkan hubungi root akun untuk bantuan");

//        If find will be validated by password
        boolean isValid = BCrypt.checkpw(loginRequestVm.getPassword(), findAccount.getPassword());
//        if not valid will return exception
        if(!isValid) throw new UnauthorizedException("Username atau Password salah");

//        If find will update last login and return response
        findAccount.setLastLogin(new Date());
        accountRepository.save(findAccount);
        return new LoginResponseVm(
                findAccount.getId(), findAccount.getUsername(), findAccount.getEmail(),
                findAccount.getFullName(), findAccount.getPhoneNumber(), findAccount.getRole().getName(),
                findAccount.getRole().getId()
        );
    }
}
