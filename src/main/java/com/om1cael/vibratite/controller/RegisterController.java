package com.om1cael.vibratite.controller;

import com.om1cael.vibratite.Main;
import com.om1cael.vibratite.dao.UserDAO;
import com.om1cael.vibratite.model.User;
import com.om1cael.vibratite.view.RegisterView;

public class RegisterController {
    RegisterView registerView;
    UserDAO userDAO;

    public RegisterController(RegisterView registerView, UserDAO userDAO) {
        this.registerView = registerView;
        this.userDAO = userDAO;

        this.handleRegister();
    }

    public void handleRegister() {
        User newUser = this.registerView.getRegisterUser();

        if(userDAO.create(newUser)) {
            Main.loggedInUser = newUser;
            registerView.successfulRegister(newUser);
        } else {
            registerView.unsuccessfulRegister();
        }
    }
}
