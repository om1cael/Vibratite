package com.om1cael.vibratite.dao;

import com.om1cael.vibratite.db.DBConnector;
import com.om1cael.vibratite.model.Game;
import com.om1cael.vibratite.model.Library;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class LibraryDAO {
    private final Connection connection;

    public LibraryDAO(DBConnector dbConnector) {
        this.connection = dbConnector.getConnection();
    }

    public boolean create(int userID, int gameID) {
        final String statement = """
                                 INSERT INTO Library (user_id, game_id)
                                 VALUES (?, ?)
                                 """;

        try(PreparedStatement preparedStatement = this.connection.prepareStatement(statement)) {
            preparedStatement.setInt(1, userID);
            preparedStatement.setInt(2, gameID);

            return preparedStatement.executeUpdate() == 1;
        } catch (SQLException e) {
            return false;
        }
    }

    public List<Game> getAll(int userID) {
        final String query = """
                             SELECT Games.id, Games.name, Games.price
                             FROM Games
                             JOIN Library ON Games.id = Library.game_id
                             WHERE Library.user_id = ?
                             """;

        List<Game> libraryGameList = new ArrayList<>();

        try(PreparedStatement preparedStatement = this.connection.prepareStatement(query)) {
            preparedStatement.setInt(1, userID);
            ResultSet resultSet = preparedStatement.executeQuery();

            while(resultSet.next()) {
                Game game = new Game(
                    resultSet.getInt("id"),
                    resultSet.getString("name"),
                    resultSet.getDouble("price")
                );

                libraryGameList.add(game);
            }

            return libraryGameList;
        } catch (SQLException e) {
            return null;
        }
    }

    public boolean delete(int userID, int gameID) {
        final String statement = """
                                 DELETE FROM Library
                                 WHERE user_id = ? AND game_id = ?
                                 """;

        try(PreparedStatement preparedStatement = this.connection.prepareStatement(statement)) {
            preparedStatement.setInt(1, userID);
            preparedStatement.setInt(2, gameID);

            return preparedStatement.executeUpdate() == 1;
        } catch (SQLException e) {
            return false;
        }
    }
}
