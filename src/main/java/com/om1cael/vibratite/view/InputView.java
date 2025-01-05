package com.om1cael.vibratite.view;

import java.util.Scanner;

public class InputView {
    Scanner scanner;

    public InputView(Scanner scanner) {
        this.scanner = scanner;
    }

    public String getTextInput(String message) {
        System.out.print(message);
        return getInput();
    }

    public Double getNumberInput(String message) {
        System.out.print(message);
        return Double.parseDouble(getInput());
    }

    public String getInput() {
        return scanner.nextLine();
    }
}
