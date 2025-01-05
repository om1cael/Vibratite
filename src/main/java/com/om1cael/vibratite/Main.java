package com.om1cael.vibratite;

import com.om1cael.vibratite.dao.UserDAO;
import com.om1cael.vibratite.db.DBConnector;

import java.sql.SQLException;

public class Main {
    public static void main(String[] args) {
        try {
            DBConnector dbConnector = new DBConnector();
        } catch (SQLException e) {
            throw new RuntimeException("An error occurred during the initialization", e);
        }
    }
}