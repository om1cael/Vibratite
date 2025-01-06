package com.om1cael.vibratite.view.Auth;

import com.om1cael.vibratite.controller.InputController;
import com.om1cael.vibratite.model.User;

public class RegisterView {
    InputController inputController;

    public RegisterView(InputController inputController) {
        this.inputController = inputController;
    }

    public User getRegisterUser() {
        String name =
                this.inputController.handleTextInput("Name: ", 4, 16);
        String email =
                this.inputController.handleTextInput("Email: ", 4, 32);

        return new User(0, name, email);
    }

    public void successfulRegister(User user) {
        System.out.println("The account " + user.name() + " was registered successfully!");
    }

    public void unsuccessfulRegister() {
        System.out.println("It was not possible to create the account.");
    }
}
