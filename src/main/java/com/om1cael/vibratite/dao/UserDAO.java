package com.om1cael.vibratite.dao;

import com.om1cael.vibratite.db.DBConnector;
import com.om1cael.vibratite.model.User;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserDAO {
    private final Connection connection;

    public UserDAO(DBConnector dbConnector) {
        this.connection = dbConnector.getConnection();
    }

    public boolean create(User user) {
        final String statement = """
                             INSERT INTO Users (name, email)
                             VALUES (?, ?)
                             """;

        try(PreparedStatement preparedStatement = this.connection.prepareStatement(statement)) {
            preparedStatement.setString(1, user.name());
            preparedStatement.setString(2, user.email());

            return preparedStatement.executeUpdate() == 1;
        } catch (SQLException e) {
            return false;
        }
    }

    public boolean exists(String name, String email) {
        final String query = """
                             SELECT * FROM Users
                             WHERE name = ? AND email = ?
                             """;

        try(PreparedStatement preparedStatement = this.connection.prepareStatement(query)) {
            preparedStatement.setString(1, name);
            preparedStatement.setString(2, email);
            ResultSet resultSet = preparedStatement.executeQuery();

            return resultSet.next();
        } catch (SQLException e) {
            return false;
        }
    }

    public List<User> getAll() {
        final String query = "SELECT * FROM Users";
        List<User> userList = new ArrayList<>();

        try(Statement statement = this.connection.createStatement()) {
            ResultSet resultSet = statement.executeQuery(query);

            while(resultSet.next()) {
                User user = new User(
                    resultSet.getInt("id"),
                    resultSet.getString("name"),
                    resultSet.getString("email")
                );

                userList.add(user);
            }
        } catch (SQLException e) {
            return null;
        }

        return userList;
    }

    public boolean delete(int id) {
        final String statement = """
                                 DELETE FROM Users
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
