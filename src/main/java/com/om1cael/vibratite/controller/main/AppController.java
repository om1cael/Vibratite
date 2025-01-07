package com.om1cael.vibratite.controller.main;

import com.om1cael.vibratite.controller.InputController;
import com.om1cael.vibratite.controller.interactions.AddGameController;
import com.om1cael.vibratite.controller.interactions.BuyGameController;
import com.om1cael.vibratite.controller.interactions.GamesController;
import com.om1cael.vibratite.controller.interactions.MyGamesController;
import com.om1cael.vibratite.dao.GameDAO;
import com.om1cael.vibratite.dao.LibraryDAO;
import com.om1cael.vibratite.db.DBConnector;
import com.om1cael.vibratite.view.interactions.AddGameView;
import com.om1cael.vibratite.view.interactions.BuyGameView;
import com.om1cael.vibratite.view.interactions.GamesView;
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
            case 2 -> this.createGamesController();
            case 3 -> this.createBuyGameController();
            case 4 -> this.createAddGameController();
            default -> System.exit(0);
        }
    }

    private void createMyGamesController() {
        new MyGamesController(
                new MyGamesView(),
                new LibraryDAO(this.dbConnector)
        ).interact();
    }

    private void createGamesController() {
        new GamesController(
                new GamesView(),
                new GameDAO(this.dbConnector)
        ).interact();
    }

    private void createBuyGameController() {
        new BuyGameController(
                new BuyGameView(this.inputController),
                new GameDAO(this.dbConnector),
                new LibraryDAO(this.dbConnector)
        ).interact();
    }

    private void createAddGameController() {
        new AddGameController(
                new AddGameView(this.inputController),
                new GameDAO(this.dbConnector)
        ).interact();
    }
}
