package com.om1cael.vibratite.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnector {
    private final Connection connection;

    public DBConnector() throws SQLException {
        final String databasePath = "database.db";
        this.connection = DriverManager.getConnection("jdbc:sqlite:" + databasePath);
    }

    public Connection getConnection() {
        return this.connection;
    }
}
