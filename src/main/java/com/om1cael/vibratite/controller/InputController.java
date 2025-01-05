package com.om1cael.vibratite.controller;

import com.om1cael.vibratite.view.InputView;

public class InputController {
    InputView inputView;

    public InputController(InputView inputView) {
        this.inputView = inputView;
    }

    public String handleTextInput(String message, int minSize, int maxSize) {
        String input;

        do {
            input = inputView.getTextInput(message);
        } while(input.length() < minSize || input.length() > maxSize);

        return input;
    }

    public Double handleNumberInput(String message, int min, int max) {
        double input;

        do {
            input = inputView.getNumberInput(message);
        } while (input < min || input > max);

        return input;
    }
}
