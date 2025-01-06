package com.om1cael.vibratite.controller.auth;

import com.om1cael.vibratite.Main;
import com.om1cael.vibratite.controller.auth.interfaces.AuthController;
import com.om1cael.vibratite.controller.main.AppController;
import com.om1cael.vibratite.dao.UserDAO;
import com.om1cael.vibratite.model.User;
import com.om1cael.vibratite.view.main.AppView;
import com.om1cael.vibratite.view.auth.LoginView;

public class LoginAuthController implements AuthController {
    LoginView loginView;
    AppController appController;
    UserDAO userDAO;

    public LoginAuthController(LoginView registerView, AppController appController, UserDAO userDAO) {
        this.loginView = registerView;
        this.appController = appController;
        this.userDAO = userDAO;
    }

    public void handleAuth() {
        User user = this.loginView.getLoginUser();

        if(userDAO.exists(user.name(), user.email())) {
            Main.loggedInUser = user;
            loginView.successfulLogin(user);

            appController.handleMenuChoice();
        } else {
            loginView.unsuccessfulLogin();
        }
    }
}
