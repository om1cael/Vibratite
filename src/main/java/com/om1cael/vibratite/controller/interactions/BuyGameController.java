package com.om1cael.vibratite.controller.interactions;

import com.om1cael.vibratite.Main;
import com.om1cael.vibratite.controller.interactions.interfaces.InteractableController;
import com.om1cael.vibratite.dao.GameDAO;
import com.om1cael.vibratite.dao.LibraryDAO;
import com.om1cael.vibratite.model.Game;
import com.om1cael.vibratite.view.interactions.BuyGameView;

public class BuyGameController implements InteractableController {
    BuyGameView buyGameView;
    GameDAO gameDAO;
    LibraryDAO libraryDAO;

    public BuyGameController(BuyGameView buyGameView, GameDAO gameDAO, LibraryDAO libraryDAO) {
        this.buyGameView = buyGameView;
        this.gameDAO = gameDAO;
        this.libraryDAO = libraryDAO;
    }

    public void interact() {
        int gameID = (int) this.buyGameView.getInput();
        int userID = Main.loggedInUser.id();

        Game game = this.gameDAO.get(gameID);

        if(game != null && this.libraryDAO.create(userID, gameID)) {
            this.buyGameView.buyMessage(game);
        } else {
            this.buyGameView.errorMessage();
        }
    }
}
