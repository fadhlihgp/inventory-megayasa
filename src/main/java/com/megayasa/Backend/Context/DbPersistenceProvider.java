package com.megayasa.Backend.Context;

import com.google.inject.Inject;
import com.google.inject.Provider;
import com.megayasa.Backend.Context.Interfaces.Persistence;

import java.sql.Connection;

public class DbPersistenceProvider implements Provider<Persistence> {
    private final Connection connection;

    @Inject
    public DbPersistenceProvider(Connection connection) {
        this.connection = connection;
    }

    @Override
    public Persistence get() {
        return new DbPersistence(connection);
    }
}
