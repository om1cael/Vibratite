package com.om1cael.vibratite.view.interactions;

import com.om1cael.vibratite.model.Game;

import java.util.List;

public class MyGamesView {
    public void showGames(List<Game> gameList) {
        if(isGameListEmptyOrNull(gameList)) return;

        for(Game game : gameList) {
            System.out.println(game.name() + " id " + game.id());
        }
    }

    private static boolean isGameListEmptyOrNull(List<Game> gameList) {
        if(gameList == null || gameList.isEmpty()) {
            System.out.println("No games found in your account.");
            return true;
        }
        return false;
    }
}
