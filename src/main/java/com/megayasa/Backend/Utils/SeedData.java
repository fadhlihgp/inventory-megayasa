package com.megayasa.Backend.Utils;

import com.megayasa.Backend.Models.Account;
import com.megayasa.Backend.Models.Position;
import com.megayasa.Backend.Models.Role;
import com.megayasa.Backend.Repositories.AccountRepository;
import com.megayasa.Backend.Repositories.PositionRepository;
import com.megayasa.Backend.Repositories.RoleRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class SeedData implements CommandLineRunner {

    private final PositionRepository positionRepository;
    private final AccountRepository accountRepository;
    private final RoleRepository roleRepository;

    @Autowired
    public SeedData(PositionRepository positionRepository, AccountRepository accountRepository, RoleRepository roleRepository) {
        this.positionRepository = positionRepository;
        this.accountRepository = accountRepository;
        this.roleRepository = roleRepository;
    }

    @Transactional
    @Override
    public void run(String... args) throws Exception {
        List<Role> roles = new ArrayList<>() {{
            add(new Role("1", "SuperAdmin"));
            add(new Role("2", "Personalia"));
            add(new Role("3", "Staff"));
        }};

        List<Position> positions = new ArrayList<>() {{
            add(new Position("50272cac-93f7-42c9-8a16-5b35859dc80f", "Staff Keuangan"));
            add(new Position("2f71adf7-d91f-46c1-8479-ca25b81b0065", "Staff Personalia"));
            add(new Position("f39c1540-4524-40fc-9d75-51ff8b9c9e0e", "Admin Operator"));
            add(new Position("345da386-3326-464c-83dc-d6fe6a401f05", "Direktur"));
        }};

        if (roleRepository.count() == 0) {
            roleRepository.saveAll(roles);
        }

        if (accountRepository.count() == 0) {
            Account account = new Account();
            account.setId("16ecf466-577a-48b9-82a9-d9431e08cf8c");
            account.setEmail("superadmin@email.com");
            account.setPassword("$2a$10$it1K5OK3rSdanv.Ns75YJuH8Z15tN0W8VlFiZqBMqybFcUMHMkVBm");
            account.setFullName("Super Admin");
            account.setRole(roles.get(0));
            account.setIsActive(true);
            account.setPhoneNumber("0898989898");
            account.setUsername("superadmin");
            accountRepository.save(account);
        }

        if (positionRepository.count() == 0) {
            positionRepository.saveAll(positions);
        }
    }
}
