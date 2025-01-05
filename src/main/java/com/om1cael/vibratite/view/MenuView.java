package com.om1cael.vibratite.view;

import com.om1cael.vibratite.controller.InputController;

public class MenuView {
    InputController inputController;

    public MenuView(InputController inputController) {
        this.inputController = inputController;
    }

    public void showJoin() {
        System.out.println("1. Create a new account");
        System.out.println("2. Login into an existing account");
        System.out.println(this.inputController.handleNumberInput("Your choice: ", 1, 2));
    }

    public void showApp() {
        System.out.println("1. My games");
        System.out.println("2. All games");
        System.out.println("3. Buy a game");
        System.out.println("4. Add my game");
        this.inputController.handleNumberInput("Your choice: ", 1, 4);
    }
}
