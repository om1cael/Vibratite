package com.om1cael.vibratite.controller.main;

import com.om1cael.vibratite.controller.InputController;
import com.om1cael.vibratite.controller.interactions.MyGamesController;
import com.om1cael.vibratite.dao.LibraryDAO;
import com.om1cael.vibratite.db.DBConnector;
import com.om1cael.vibratite.view.interactions.MyGamesView;
import com.om1cael.vibratite.view.main.AppView;

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
            case 1 -> this.createMyGamesController();
            default -> System.exit(0);
        }
    }

    private void createMyGamesController() {
        new MyGamesController(
                new MyGamesView(),
                new LibraryDAO(this.dbConnector)
        ).interact();
    }
}
