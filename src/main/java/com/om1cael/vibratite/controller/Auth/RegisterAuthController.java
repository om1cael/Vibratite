package com.om1cael.vibratite.controller.Auth;

import com.om1cael.vibratite.Main;
import com.om1cael.vibratite.controller.Auth.interfaces.AuthController;
import com.om1cael.vibratite.dao.UserDAO;
import com.om1cael.vibratite.model.User;
import com.om1cael.vibratite.view.MainApp.AppView;
import com.om1cael.vibratite.view.Auth.RegisterView;

public class RegisterAuthController implements AuthController {
    RegisterView registerView;
    AppView appView;
    UserDAO userDAO;

    public RegisterAuthController(RegisterView registerView, AppView appView, UserDAO userDAO) {
        this.registerView = registerView;
        this.appView = appView;
        this.userDAO = userDAO;
    }

    public void handleAuth() {
        User newUser = this.registerView.getRegisterUser();

        if(userDAO.create(newUser)) {
            Main.loggedInUser = newUser;
            registerView.successfulRegister(newUser);

            appView.showApp();
        } else {
            registerView.unsuccessfulRegister();
        }
    }
}
