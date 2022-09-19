package com.company.service;

import com.company.model.DbManager;
import com.company.model.entities.Country;

import java.util.List;

public class CountriesService {
    private DbManager dbManager;

    public CountriesService() throws Exception {
        try {
            dbManager = DbManager.getInstance();
        } catch (Exception e) {
            throw new Exception("Ошибка инициализации базы данных: " + e.getMessage());
        }
    }

    public List<Country> getAllCountries() throws Exception {
        try {
            return dbManager.getTableCountries().getAllCountries();
        } catch (Exception e) {
            throw new Exception("Ошибка работы с базой данных: " + e.getMessage());
        }
    }
}