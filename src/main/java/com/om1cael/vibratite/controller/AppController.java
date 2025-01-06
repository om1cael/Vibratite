package com.om1cael.vibratite.controller;

import com.om1cael.vibratite.db.DBConnector;
import com.om1cael.vibratite.view.AppView;

public class AppController {
    private final AppView appView;
    private final InputController inputController;
    private final DBConnector dbConnector;

    public AppController(AppView appView, InputController inputController, DBConnector dbConnector) {
        this.appView = appView;
        this.inputController = inputController;
        this.dbConnector = dbConnector;
    }

    public void handleMenuChoice() {
        appView.showApp();
        int choice = (int) appView.getAppInput();

        switch(choice) {
            case 1 -> System.out.println();
            default -> System.exit(0);
        }
    }
}
