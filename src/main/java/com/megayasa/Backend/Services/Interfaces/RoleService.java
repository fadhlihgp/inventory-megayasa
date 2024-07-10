package com.megayasa.Backend.Services.Interfaces;

import com.megayasa.Backend.Models.Role;

import java.util.List;

public interface RoleService {
    Role findById(String id);
    List<Role> findAll();
}
