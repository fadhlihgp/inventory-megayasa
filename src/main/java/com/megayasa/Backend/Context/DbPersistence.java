package com.megayasa.Backend.Context;

import com.megayasa.Backend.Context.Interfaces.Persistence;

import java.sql.Connection;
import java.sql.SQLException;

public class DbPersistence implements Persistence {
    private final Connection connection;
    public DbPersistence(Connection connection) {
        this.connection = connection;
    }

    @Override
    public void beginTransaction() {
        try {
            connection.setAutoCommit(false);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void commit() {
        try {
            connection.commit();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void rollback() {
        try {
            connection.rollback();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void closeConnection() {
        try {
            connection.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
