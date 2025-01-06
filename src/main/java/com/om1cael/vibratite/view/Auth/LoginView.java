package com.om1cael.vibratite.view.Auth;

import com.om1cael.vibratite.controller.InputController;
import com.om1cael.vibratite.model.User;

public class LoginView {
    InputController inputController;

    public LoginView(InputController inputController) {
        this.inputController = inputController;
    }

    public User getLoginUser() {
        String name =
                this.inputController.handleTextInput("Name: ", 4, 16);
        String email =
                this.inputController.handleTextInput("Email: ", 4, 32);

        return new User(0, name, email);
    }

    public void successfulLogin(User user) {
        System.out.println("Login to " + user.name() + " was successful!");
    }

    public void unsuccessfulLogin() {
        System.out.println("It was not possible to login.");
    }
}
