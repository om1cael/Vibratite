package com.om1cael.vibratite.controller.interactions;

import com.om1cael.vibratite.Main;
import com.om1cael.vibratite.dao.LibraryDAO;
import com.om1cael.vibratite.model.Game;
import com.om1cael.vibratite.view.interactions.MyGamesView;

import java.util.List;

public class MyGamesController {
    MyGamesView myGamesView;
    LibraryDAO libraryDAO;

    public MyGamesController(MyGamesView myGamesView, LibraryDAO libraryDAO) {
        this.myGamesView = myGamesView;
        this.libraryDAO = libraryDAO;
    }

    public void interact() {
        this.myGamesView.showGames(this.getGames());
    }

    private List<Game> getGames() {
        final int userID = Main.loggedInUser.id();
        return this.libraryDAO.getAll(userID);
    }
}
