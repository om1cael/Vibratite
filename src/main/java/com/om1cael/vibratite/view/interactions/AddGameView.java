package com.om1cael.vibratite.view.interactions;

import com.om1cael.vibratite.controller.InputController;
import com.om1cael.vibratite.model.Game;

public class AddGameView {
    InputController inputController;

    public AddGameView(InputController inputController) {
        this.inputController = inputController;
    }

    public void addMessage(Game game) {
        System.out.println("You added the game " + game.name() + "!");
    }

    public void errorMessage() {
        System.out.println("It was not possible to add the game.");
    }

    public String getTextInput(String message, int minSize, int maxSize) {
        return this.inputController.handleTextInput(message, minSize, maxSize);
    }

    public double getNumberInput(String message, int min, int max) {
        return this.inputController.handleNumberInput(message, min, max);
    }
}
