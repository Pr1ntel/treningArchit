package com.company.model;

import com.company.model.connection.DbConnection;
import com.company.model.tables.TableCountries;
import com.company.model.tables.TableUsers;

import java.sql.Connection;
import java.sql.SQLException;


public class DbManager {
    private TableUsers tableUsers;
    private TableCountries tableCountries;

    private DbManager() throws SQLException {
        Connection connection = DbConnection.getInstance().getConnection();

        tableUsers = new TableUsers(connection);
        tableCountries = new TableCountries(connection);
    }

    public TableUsers getTableUsers() {
        return tableUsers;
    }

    public TableCountries getTableCountries() {
        return tableCountries;
    }

    private static DbManager instance;

    public static DbManager getInstance() throws SQLException {
        if (instance == null) {
            instance = new DbManager();
        }
        return instance;
    }
}