package com.megayasa.Backend.Services.Interfaces;

import com.megayasa.Backend.ViewModels.Requests.LoginRequestVm;
import com.megayasa.Backend.ViewModels.Responses.LoginResponseVm;

public interface LoginService {
    LoginResponseVm login(LoginRequestVm loginRequestVm);
}
