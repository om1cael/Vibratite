package com.om1cael.vibratite.controller;

import com.om1cael.vibratite.view.MenuView;

public class MenuController {
    private final MenuView menuView;

    public MenuController(MenuView menuView) {
        this.menuView = menuView;

        this.handleJoinChoice();
    }

    public void handleJoinChoice() {
        int choice = (int) menuView.showJoin();

        switch(choice) {
            case 1 -> System.out.println("Register");
            case 2 -> System.out.println("Login");
            default -> System.out.println("Invalid");
        }
    }
}
