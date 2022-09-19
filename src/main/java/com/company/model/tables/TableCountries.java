package com.company.model.tables;

import com.company.model.entities.Country;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class TableCountries {
    private Connection connection;

    public TableCountries(Connection connection) {
        this.connection = connection;
    }

    public List<Country> getAllCountries() throws SQLException {
        List<Country> countries = new ArrayList<>();

        Statement statement = connection.createStatement();

        String selectQuery = String.format("SELECT * FROM countries ORDER BY id ASC");

        ResultSet resultSet = statement.executeQuery(selectQuery);

        while (resultSet.next()) {

            int id = resultSet.getInt("id");
            String name = resultSet.getString("name");
            int population = resultSet.getInt("population");

            countries.add(new Country(id, name, population));
        }
        resultSet.close();

        statement.close();

        return countries;
    }
}