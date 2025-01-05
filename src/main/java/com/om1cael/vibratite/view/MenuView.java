package com.om1cael.vibratite.view;

import com.om1cael.vibratite.controller.InputController;

public class MenuView {
    InputController inputController;

    public MenuView(InputController inputController) {
        this.inputController = inputController;
    }

    public void showMenu() {
        System.out.println("1. Create a new account");
        System.out.println("2. Login into an existing account");
        System.out.println("3. Exit");
    }

    public double getMenuInput() {
        return this.inputController.handleNumberInput("Your choice: ", 1, 3);
    }
}
