package com.company.model.tables;

import com.company.model.entities.User;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class TableUsers {
    private Connection connection;

    public TableUsers(Connection connection) {
        this.connection = connection;
    }

    public List<User> getAllUsers() throws SQLException {
        List<User> users = new ArrayList<>();

        Statement statement = connection.createStatement();

        String selectQuery = String.format("SELECT * FROM users ORDER BY id ASC");

        ResultSet resultSet = statement.executeQuery(selectQuery);

        while (resultSet.next()) {

            int id = resultSet.getInt("id");
            String name = resultSet.getString("name");
            int age = resultSet.getInt("age");
            int countryId = resultSet.getInt("country_id");

            users.add(new User(id, name, age, countryId));
        }
        resultSet.close();

        statement.close();

        return users;
    }

    public void addNewUser(User user) throws SQLException {
        Statement statement = connection.createStatement();

        String insertQuery = String.format("INSERT INTO users (name, country_id, age)\n" +
                "VALUES ('%s',%d,%d)", user.getName(), user.getCountryId(), user.getAge());

        statement.executeUpdate(insertQuery);

        statement.close();
    }

    public void deleteUser(int id) throws SQLException {
        Statement statement = connection.createStatement();
        String deleteQuery = String.format("DELETE FROM users WHERE id = %d", id);

        statement.executeUpdate(deleteQuery);
        statement.close();
    }

    public void updateUserFromAge(User user) throws SQLException {
        Statement statement = connection.createStatement();
        String updateQuery = String.format("SELECT part,text FROM questions WHERE id = %d", user.getAge());

        statement.executeUpdate(updateQuery);
        statement.close();
    }
}
