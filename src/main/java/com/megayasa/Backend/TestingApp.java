package com.megayasa.Backend;

import com.megayasa.Backend.Controllers.LoginController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.Scanner;

@Component
public class TestingApp implements CommandLineRunner {
    private LoginController loginController;

    @Autowired
    public TestingApp(LoginController loginController) {
        this.loginController = loginController;
    }

    @Override
    public void run(String... args) throws Exception {
//        Scanner input = new Scanner(System.in);
//        System.out.print("Username: ");
//        String username = input.nextLine();
//        System.out.println("Password: ");
//        String password = input.nextLine();
//
//        var login = loginController.login(new LoginRequestVm(username, password));
//        System.out.println(login);
    }
}
