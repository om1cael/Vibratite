package com.om1cael.vibratite.controller.Auth;

import com.om1cael.vibratite.Main;
import com.om1cael.vibratite.controller.Auth.interfaces.AuthController;
import com.om1cael.vibratite.dao.UserDAO;
import com.om1cael.vibratite.model.User;
import com.om1cael.vibratite.view.MainApp.AppView;
import com.om1cael.vibratite.view.Auth.LoginView;

public class LoginAuthController implements AuthController {
    LoginView loginView;
    AppView appView;
    UserDAO userDAO;

    public LoginAuthController(LoginView registerView, AppView appView, UserDAO userDAO) {
        this.loginView = registerView;
        this.appView = appView;
        this.userDAO = userDAO;
    }

    public void handleAuth() {
        User user = this.loginView.getLoginUser();

        if(userDAO.exists(user.name(), user.email())) {
            Main.loggedInUser = user;
            loginView.successfulLogin(user);

            appView.showApp();
        } else {
            loginView.unsuccessfulLogin();
        }
    }
}
