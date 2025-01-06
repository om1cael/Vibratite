package com.om1cael.vibratite.controller;

import com.om1cael.vibratite.dao.UserDAO;
import com.om1cael.vibratite.db.DBConnector;
import com.om1cael.vibratite.view.AppView;
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
    }

    public void handleMenuChoice() {
        menuView.showMenu();
        int choice = (int) menuView.getMenuInput();

        switch(choice) {
            case 1 -> this.createRegisterAuthController();
            case 2 -> this.createLoginAuthController();
            default -> System.exit(0);
        }
    }

    private void createRegisterAuthController() {
        new RegisterAuthController(
                new RegisterView(this.inputController),
                new AppView(this.inputController),
                new UserDAO(this.dbConnector)
        ).handleAuth();
    }

    private void createLoginAuthController() {
        new LoginAuthController(
                new LoginView(this.inputController),
                new AppView(this.inputController),
                new UserDAO(this.dbConnector)
        ).handleAuth();
    }
}
