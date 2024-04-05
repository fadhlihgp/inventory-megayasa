package com.megayasa.Backend.Services;

import com.google.inject.Inject;
import com.megayasa.Backend.Exceptions.NotFoundException;
import com.megayasa.Backend.Models.Role;
import com.megayasa.Backend.Repositories.RoleRepository;
import com.megayasa.Backend.Services.Interfaces.RoleService;

import java.util.List;

public class RoleServiceImpl implements RoleService {
    private final RoleRepository roleRepository;

    @Inject
    public RoleServiceImpl(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }

    @Override
    public Role findById(String id) {
        return roleRepository.findById(id).orElseThrow(() -> new NotFoundException("Role tidak ditemukan"));
    }

    @Override
    public List<Role> findAll() {
        return roleRepository.findAll();
    }
}
