package com.megayasa.Backend.Context;

import com.google.inject.Provider;

import java.sql.Connection;

public class AppDbContextConnectionProvider implements Provider<Connection> {
    @Override
    public Connection get() {
        AppDbContext context = new AppDbContext();
        return context.getConnection();
    }
}
