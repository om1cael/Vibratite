package com.om1cael.vibratite.controller.interactions;

import com.om1cael.vibratite.Main;
import com.om1cael.vibratite.controller.interactions.interfaces.InteractableController;
import com.om1cael.vibratite.dao.GameDAO;
import com.om1cael.vibratite.dao.LibraryDAO;
import com.om1cael.vibratite.model.Game;
import com.om1cael.vibratite.view.interactions.AddGameView;
import com.om1cael.vibratite.view.interactions.BuyGameView;

public class AddGameController implements InteractableController {
    AddGameView addGameView;
    GameDAO gameDAO;

    public AddGameController(AddGameView addGameView, GameDAO gameDAO) {
        this.addGameView = addGameView;
        this.gameDAO = gameDAO;
    }

    public void interact() {
        String title = this.addGameView.getTextInput("Title: ", 4, 16);
        double price = this.addGameView.getNumberInput("Price: ", 0, 1000);

        Game game = new Game(0, title, price);

        if(gameDAO.create(game)) {
            this.addGameView.addMessage(game);
        } else {
            this.addGameView.errorMessage();
        }
    }
}
