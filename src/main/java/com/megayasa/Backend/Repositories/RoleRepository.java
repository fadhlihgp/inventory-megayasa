package com.megayasa.Backend.Repositories;

import com.megayasa.Backend.Models.Role;

import java.util.List;
import java.util.Optional;

public interface RoleRepository {
    Optional<Role> findById(String id);
    List<Role> findAll();
}
