package com.megayasa.Backend.Context.Interfaces;

public interface Persistence {
    void beginTransaction();
    void commit();
    void rollback();
    void closeConnection();
}
