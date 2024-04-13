package com.megayasa.Backend.Controllers;

import com.google.inject.Inject;
import com.megayasa.Backend.Models.Role;
import com.megayasa.Backend.Services.Interfaces.RoleService;

import java.util.List;

public class RoleController {
    private final RoleService roleService;

    @Inject
    public RoleController(RoleService roleService) {
        this.roleService = roleService;
    }

    public List<Role> findAllRoles() {
        return roleService.findAll();
    }
}
