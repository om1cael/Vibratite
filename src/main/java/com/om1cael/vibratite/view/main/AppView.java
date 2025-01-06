package com.om1cael.vibratite.view.main;

import com.om1cael.vibratite.controller.InputController;

public class AppView {
    InputController inputController;

    public AppView(InputController inputController) {
        this.inputController = inputController;
    }

    public void showApp() {
        System.out.println("1. My games");
        System.out.println("2. All games");
        System.out.println("3. Buy a game");
        System.out.println("4. Add my game");
        System.out.println("5. Exit");
    }

    public double getAppInput() {
        return this.inputController.handleNumberInput("Your choice: ", 1, 5);
    }
}
