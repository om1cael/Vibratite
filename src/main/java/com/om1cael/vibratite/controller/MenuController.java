package com.om1cael.vibratite.controller;

import com.om1cael.vibratite.view.MenuView;

public class MenuController {
    private final MenuView menuView;

    public MenuController(MenuView menuView) {
        this.menuView = menuView;

        this.handleJoinChoice();
    }

    public void handleJoinChoice() {
        menuView.showJoin();
    }
}
