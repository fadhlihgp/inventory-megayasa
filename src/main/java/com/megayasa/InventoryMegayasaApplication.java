package com.megayasa;

import com.google.inject.Guice;
import com.megayasa.Backend.Controllers.AbsenceController;
import com.megayasa.Backend.Controllers.AccountController;
import com.megayasa.Backend.Controllers.EmployeeController;
import com.megayasa.Backend.Controllers.LoginInformationController;
import com.megayasa.Backend.Models.LoginInformation;
import com.megayasa.Backend.Repositories.AccountRepository;
import com.megayasa.Backend.Utils.Injection;
import com.megayasa.Backend.ViewModels.Requests.AccountRequestVm;
import com.megayasa.Backend.ViewModels.Requests.EmployeeRequestVm;
import java.sql.Date;

public class InventoryMegayasaApplication {

    public static void main(String[] args) {
        AccountRepository accountRepository = Guice.createInjector(new Injection()).getInstance(AccountRepository.class);
//        System.out.println(accountRepository.findById("16ecf466-577a-48b9-82a9-d94dsdd31e08cf8c"));
//        SpringApplication.run(InventoryMegayasaApplication.class, args);
//        new SpringApplicationBuilder(InventoryMegayasaApplication.class)
//                .headless(false).run(args);
//        testAccount();
//        testEmployee();
//        loginInformation();
        absenceTest();
    }

    private static void testAccount() {
        AccountController accountController = Guice.createInjector(new Injection()).getInstance(AccountController.class);
        AccountRequestVm createAccount = new AccountRequestVm();
        createAccount.setFullName("Andi");
        createAccount.setUsername("andi");
        createAccount.setEmail("andi@email.com");
        createAccount.setPassword("Unindra123/");
        createAccount.setPhoneNumber("0891284334");
        createAccount.setRoleId("1");
        createAccount.setActive(true);

//        accountController.updateAccount("6de99109-6ae7-4da2-a461-846f7d674471", createAccount);
//        accountRepository.createAccount(createAccount);
        accountController.deleteAccount("951cc965-6e62-4ad1-9bc4-55cb3e15c39f");
    }

    private static void testEmployee(){
        EmployeeController employeeController = Guice.createInjector(new Injection()).getInstance(EmployeeController.class);

        EmployeeRequestVm employeeRequestVm = new EmployeeRequestVm();
        employeeRequestVm.setEmployeeId("123345");
        employeeRequestVm.setAddress("Bekasi");
        employeeRequestVm.setGender("Laki-Laki");
        employeeRequestVm.setFullName("Indra Gunawan");
        employeeRequestVm.setPhoneNumber("08839223");
        employeeRequestVm.setPositionId("345da386-3326-464c-83dc-d6fe6a401f05");
        employeeRequestVm.setIdentityNumber("3276322333");
        employeeRequestVm.setBirthDate(new Date(2000-1900, 10, 17));

//        employeeController.createOrUpdateEmployee("123345", employeeRequestVm);
        System.out.println(employeeController.findAllEmployees());
//        employeeController.deleteEmployee("123345");
    }

    private static void loginInformation() {
        LoginInformationController loginInformationController = Guice.createInjector(new Injection()).getInstance(LoginInformationController.class);
//        LoginInformation loginInformation1 = loginInformationController.currentLogin();
        final Boolean aBoolean = loginInformationController.deleteLoginInformation();
        System.out.println(aBoolean);
    }

    private static void absenceTest() {
        AbsenceController absenceController = Guice.createInjector(new Injection()).getInstance(AbsenceController.class);
        System.out.println(absenceController.absenceDetailList());
    }
}
