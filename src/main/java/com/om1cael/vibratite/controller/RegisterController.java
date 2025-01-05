package com.om1cael.vibratite.controller;

import com.om1cael.vibratite.Main;
import com.om1cael.vibratite.controller.interfaces.Auth;
import com.om1cael.vibratite.dao.UserDAO;
import com.om1cael.vibratite.model.User;
import com.om1cael.vibratite.view.MenuView;
import com.om1cael.vibratite.view.RegisterView;

public class RegisterController implements Auth {
    RegisterView registerView;
    MenuView menuView;
    UserDAO userDAO;

    public RegisterController(RegisterView registerView, MenuView menuView, UserDAO userDAO) {
        this.registerView = registerView;
        this.menuView = menuView;
        this.userDAO = userDAO;
    }

    public void handleAuth() {
        User newUser = this.registerView.getRegisterUser();

        if(userDAO.create(newUser)) {
            Main.loggedInUser = newUser;
            registerView.successfulRegister(newUser);

            menuView.showApp();
        } else {
            registerView.unsuccessfulRegister();
        }
    }
}
