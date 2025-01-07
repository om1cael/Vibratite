package com.om1cael.vibratite.view.interactions;

import com.om1cael.vibratite.controller.InputController;
import com.om1cael.vibratite.model.Game;

import java.util.List;

public class BuyGameView {
    InputController inputController;

    public BuyGameView(InputController inputController) {
        this.inputController = inputController;
    }

    public void buyMessage(Game game) {
        System.out.println("You bought the game " + game.name() + "!");
    }

    public void errorMessage() {
        System.out.println("It was not possible to buy the game.");
    }

    public double getInput() {
        return this.inputController.handleNumberInput("Game ID: ", 0, Integer.MAX_VALUE);
    }
}
