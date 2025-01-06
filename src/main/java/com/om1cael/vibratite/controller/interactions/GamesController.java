package com.om1cael.vibratite.controller.interactions;

import com.om1cael.vibratite.Main;
import com.om1cael.vibratite.controller.interactions.interfaces.InteractableController;
import com.om1cael.vibratite.dao.GameDAO;
import com.om1cael.vibratite.dao.LibraryDAO;
import com.om1cael.vibratite.model.Game;
import com.om1cael.vibratite.view.interactions.GamesView;
import com.om1cael.vibratite.view.interactions.MyGamesView;

import java.util.List;

public class GamesController implements InteractableController {
    GamesView gamesView;
    GameDAO gameDAO;

    public GamesController(GamesView gamesView, GameDAO gameDAO) {
        this.gamesView = gamesView;
        this.gameDAO = gameDAO;
    }

    public void interact() {
        this.gamesView.showGames(this.getGames());
    }

    private List<Game> getGames() {
        return this.gameDAO.getAll();
    }
}
