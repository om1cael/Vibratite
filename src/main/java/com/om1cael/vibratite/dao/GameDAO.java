package com.om1cael.vibratite.dao;

import com.om1cael.vibratite.db.DBConnector;
import com.om1cael.vibratite.model.Game;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class GameDAO {
    private final Connection connection;

    public GameDAO(DBConnector dbConnector) {
        this.connection = dbConnector.getConnection();
    }

    public boolean create(Game game) {
        final String statement = """
                                 INSERT INTO Games (name, price)
                                 VALUES (?, ?)
                                 """;

        try (PreparedStatement preparedStatement = this.connection.prepareStatement(statement)) {
            preparedStatement.setString(1, game.name());
            preparedStatement.setDouble(2, game.price());

            return preparedStatement.executeUpdate() == 1;
        } catch (SQLException e) {
            return false;
        }
    }

    public Game get(int id) {
        final String query = """
                             SELECT * FROM Games
                             WHERE id = ?
                             """;

        try(PreparedStatement preparedStatement = this.connection.prepareStatement(query)) {
            preparedStatement.setInt(1, id);

            ResultSet resultSet = preparedStatement.executeQuery();

            if(resultSet.next()) {
                return new Game(
                    resultSet.getInt("id"),
                    resultSet.getString("name"),
                    resultSet.getDouble("price")
                );
            }

            return null;
        } catch (SQLException e) {
            return null;
        }
    }

    public List<Game> getAll() {
        final String query = "SELECT * FROM Games";
        List<Game> gameList = new ArrayList<>();

        try(Statement statement = this.connection.createStatement()) {
            ResultSet resultSet = statement.executeQuery(query);

            while(resultSet.next()) {
                Game game = new Game(
                    resultSet.getInt("id"),
                    resultSet.getString("name"),
                    resultSet.getDouble("price")
                );

                gameList.add(game);
            }
        } catch (SQLException e) {
            return null;
        }

        return gameList;
    }

    public boolean delete(int id) {
        final String statement = """
                                 DELETE FROM Games
                                 WHERE id = ?
                                 """;

        try(PreparedStatement preparedStatement = this.connection.prepareStatement(statement)) {
            preparedStatement.setInt(1, id);
            return preparedStatement.executeUpdate() == 1;
        } catch (SQLException e) {
            return false;
        }
    }
}
