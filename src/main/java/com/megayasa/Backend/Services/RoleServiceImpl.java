package com.megayasa.Backend.Services;

import com.megayasa.Backend.Exceptions.NotFoundException;
import com.megayasa.Backend.Models.Role;
import com.megayasa.Backend.Repositories.RoleRepository;
import com.megayasa.Backend.Services.Interfaces.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RoleServiceImpl implements RoleService {
    private final RoleRepository roleRepository;

    @Autowired
    public RoleServiceImpl(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }

    @Override
    public Role findById(String id) {
        return roleRepository.findById(id).orElseThrow(() -> new NotFoundException("Role tidak ditemukan"));
    }
}
