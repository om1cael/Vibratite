package com.om1cael.vibratite.controller.main;

import com.om1cael.vibratite.controller.auth.LoginAuthController;
import com.om1cael.vibratite.controller.auth.RegisterAuthController;
import com.om1cael.vibratite.controller.InputController;
import com.om1cael.vibratite.dao.UserDAO;
import com.om1cael.vibratite.db.DBConnector;
import com.om1cael.vibratite.view.auth.LoginView;
import com.om1cael.vibratite.view.main.AppView;
import com.om1cael.vibratite.view.main.MenuView;
import com.om1cael.vibratite.view.auth.RegisterView;

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
                new AppController(new AppView(this.inputController), this.inputController, this.dbConnector),
                new UserDAO(this.dbConnector)
        ).handleAuth();
    }

    private void createLoginAuthController() {
        new LoginAuthController(
                new LoginView(this.inputController),
                new AppController(new AppView(this.inputController), this.inputController, this.dbConnector),
                new UserDAO(this.dbConnector)
        ).handleAuth();
    }
}
