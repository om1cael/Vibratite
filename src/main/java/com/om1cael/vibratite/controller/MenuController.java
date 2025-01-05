package com.om1cael.vibratite.controller;

import com.om1cael.vibratite.dao.UserDAO;
import com.om1cael.vibratite.db.DBConnector;
import com.om1cael.vibratite.view.MenuView;
import com.om1cael.vibratite.view.RegisterView;

public class MenuController {
    private final MenuView menuView;
    private final InputController inputController;
    private final DBConnector dbConnector;

    public MenuController(MenuView menuView, InputController inputController, DBConnector dbConnector) {
        this.menuView = menuView;
        this.inputController = inputController;
        this.dbConnector = dbConnector;

        this.handleJoinChoice();
    }

    public void handleJoinChoice() {
        int choice = (int) menuView.showJoin();

        switch(choice) {
            case 1: {
                new RegisterController(
                    new RegisterView(this.inputController),
                    this.menuView,
                    new UserDAO(this.dbConnector)
                );
            }

            case 2: System.out.println("Login");
            default: System.out.println("Invalid");
        }
    }
}
