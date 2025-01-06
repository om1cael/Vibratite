package com.om1cael.vibratite;

import com.om1cael.vibratite.controller.InputController;
import com.om1cael.vibratite.controller.MenuController;
import com.om1cael.vibratite.db.DBConnector;
import com.om1cael.vibratite.model.User;
import com.om1cael.vibratite.view.InputView;
import com.om1cael.vibratite.view.MenuView;

import java.sql.SQLException;
import java.util.Scanner;

public class Main {
    public static User loggedInUser = null;

    public static void main(String[] args) {
        try {
            DBConnector dbConnector = new DBConnector();

            InputView inputView = new InputView(new Scanner(System.in));
            InputController inputController = new InputController(inputView);

            MenuView menuView = new MenuView(inputController);
            new MenuController(menuView, inputController, dbConnector)
                    .handleMenuChoice();
        } catch (SQLException e) {
            throw new RuntimeException("An error occurred during the initialization", e);
        }
    }
}