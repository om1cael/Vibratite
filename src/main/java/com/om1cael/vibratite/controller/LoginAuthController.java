package com.om1cael.vibratite.controller;

import com.om1cael.vibratite.Main;
import com.om1cael.vibratite.controller.interfaces.AuthController;
import com.om1cael.vibratite.dao.UserDAO;
import com.om1cael.vibratite.model.User;
import com.om1cael.vibratite.view.LoginView;
import com.om1cael.vibratite.view.MenuView;

public class LoginAuthController implements AuthController {
    LoginView loginView;
    MenuView menuView;
    UserDAO userDAO;

    public LoginAuthController(LoginView registerView, MenuView menuView, UserDAO userDAO) {
        this.loginView = registerView;
        this.menuView = menuView;
        this.userDAO = userDAO;
    }

    public void handleAuth() {
        User user = this.loginView.getLoginUser();

        if(userDAO.exists(user.name(), user.email())) {
            Main.loggedInUser = user;
            loginView.successfulLogin(user);

            menuView.showApp();
        } else {
            loginView.unsuccessfulLogin();
        }
    }
}
