package com.om1cael.vibratite.controller.MainApp;

import com.om1cael.vibratite.controller.Auth.LoginAuthController;
import com.om1cael.vibratite.controller.Auth.RegisterAuthController;
import com.om1cael.vibratite.controller.InputController;
import com.om1cael.vibratite.dao.UserDAO;
import com.om1cael.vibratite.db.DBConnector;
import com.om1cael.vibratite.view.MainApp.AppView;
import com.om1cael.vibratite.view.Auth.LoginView;
import com.om1cael.vibratite.view.MainApp.MenuView;
import com.om1cael.vibratite.view.Auth.RegisterView;

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
