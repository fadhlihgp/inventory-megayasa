package com.megayasa.Backend;

import com.megayasa.Backend.Controllers.AccountController;
import com.megayasa.Backend.Controllers.LoginController;
import com.megayasa.Backend.Controllers.PositionController;
import com.megayasa.Backend.ViewModels.Requests.LoginRequestVm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.Scanner;

@Component
public class TestingApp implements CommandLineRunner {
    private LoginController loginController;
    private AccountController accountController;
    private PositionController positionController;

    @Autowired
    public TestingApp(LoginController loginController, AccountController accountController, PositionController positionController) {
        this.loginController = loginController;
        this.accountController = accountController;
        this.positionController = positionController;
    }

    @Override
    public void run(String... args) throws Exception {
        Scanner input = new Scanner(System.in);
//        System.out.print("Username: ");
//        String username = input.nextLine();
//        System.out.print("Password: ");
//        String password = input.nextLine();
//
//        var login = loginController.login(new LoginRequestVm(username, password));
//        System.out.println(login.toString());
//        testAccount();
//        testPosition();
    }

    private void testAccount() {
//        Scanner input = new Scanner(System.in);
//        System.out.print("Full Name: ");
//        String fullName = input.nextLine();
//        System.out.print("Username: ");
//        String username = input.nextLine();
//        System.out.print("Email: ");
//        String email = input.nextLine();
//        System.out.print("Password: ");
//        String password = input.nextLine();
//        System.out.print("Phone Number: ");
//        String phoneNumber = input.nextLine();
//        System.out.print("RoleId: ");
//        String roleId = input.nextLine();
//        System.out.print("IsActive: ");
//        boolean isActive = input.nextBoolean();
//
//        AccountRequestVm createAccount = new AccountRequestVm();
//        createAccount.setFullName(fullName);
//        createAccount.setUsername(username);
//        createAccount.setEmail(email);
//        createAccount.setPassword(password);
//        createAccount.setPhoneNumber(phoneNumber);
//        createAccount.setRoleId(roleId);
//        createAccount.setIsActive(isActive);

//        accountController.updateAccount("6de99109-6ae7-4da2-a461-846f7d674471", createAccount);
//        accountController.createAccount(createAccount);
        System.out.println(accountController.getAllAccounts().toString());
    }

    private void testPosition() {
        System.out.println(positionController.findAllPositions());
    }
}
