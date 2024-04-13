package com.megayasa.Backend.Repositories.Impl;

import com.google.inject.Inject;
import com.megayasa.Backend.Models.Role;
import com.megayasa.Backend.Repositories.RoleRepository;

import java.sql.Connection;
import java.util.List;
import java.util.Optional;

public class RoleRepositoryImpl implements RoleRepository {
    private final QueryRepositoryImpl<Role, String> queryRepository;

    @Inject
    public RoleRepositoryImpl(Connection connection) {
        this.queryRepository = new QueryRepositoryImpl<>(Role.class, connection);
    }

    @Override
    public Optional<Role> findById(String id) {
        return queryRepository.findById(id);
    }

    @Override
    public List<Role> findAll() {
        return queryRepository.findAll();
    }
}
