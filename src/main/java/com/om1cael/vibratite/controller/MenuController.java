package com.om1cael.vibratite.controller;

import com.om1cael.vibratite.dao.UserDAO;
import com.om1cael.vibratite.db.DBConnector;
import com.om1cael.vibratite.view.LoginView;
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
            case 1 -> this.createRegisterController();
            case 2 -> this.createLoginController();
            default -> System.out.println("Invalid");
        }
    }

    private void createRegisterController() {
        new RegisterController(
                new RegisterView(this.inputController),
                this.menuView,
                new UserDAO(this.dbConnector)
        ).handleAuth();
    }

    private void createLoginController() {
        new LoginController(
                new LoginView(this.inputController),
                this.menuView,
                new UserDAO(this.dbConnector)
        ).handleAuth();
    }
}
