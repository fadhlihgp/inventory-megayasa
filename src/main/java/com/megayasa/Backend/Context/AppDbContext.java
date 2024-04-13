package com.megayasa.Backend.Context;


import com.megayasa.Backend.Utils.DataProperties;

import java.sql.Connection;
import java.sql.DriverManager;

public class AppDbContext {
    private final String url = DataProperties.URL_DB;
    private final String user = DataProperties.USER_DB;
    private final String password = DataProperties.PASSWORD_DB;

    public Connection getConnection() {
        Connection connection;
        try {
            connection = DriverManager.getConnection(url, user, password);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return connection;
    }
}
