package com.om1cael.vibratite;

import com.om1cael.vibratite.controller.MenuController;
import com.om1cael.vibratite.db.DBConnector;
import com.om1cael.vibratite.view.MenuView;

import java.sql.SQLException;

public class Main {
    public static void main(String[] args) {
        try {
            DBConnector dbConnector = new DBConnector();
            MenuView menuView = new MenuView();

            new MenuController(menuView);
        } catch (SQLException e) {
            throw new RuntimeException("An error occurred during the initialization", e);
        }
    }
}