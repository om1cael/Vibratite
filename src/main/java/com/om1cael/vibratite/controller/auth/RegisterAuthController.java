package com.om1cael.vibratite.controller.auth;

import com.om1cael.vibratite.Main;
import com.om1cael.vibratite.controller.auth.interfaces.AuthController;
import com.om1cael.vibratite.controller.main.AppController;
import com.om1cael.vibratite.dao.UserDAO;
import com.om1cael.vibratite.model.User;
import com.om1cael.vibratite.view.auth.RegisterView;

public class RegisterAuthController implements AuthController {
    RegisterView registerView;
    AppController appController;
    UserDAO userDAO;

    public RegisterAuthController(RegisterView registerView, AppController appController, UserDAO userDAO) {
        this.registerView = registerView;
        this.appController = appController;
        this.userDAO = userDAO;
    }

    public void handleAuth() {
        User newUser = this.registerView.getRegisterUser();

        if(userDAO.create(newUser)) {
            Main.loggedInUser = newUser;
            registerView.successfulRegister(newUser);

            appController.handleMenuChoice();
        } else {
            registerView.unsuccessfulRegister();
        }
    }
}
