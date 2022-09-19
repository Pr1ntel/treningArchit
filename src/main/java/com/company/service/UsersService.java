package com.company.service;

import com.company.model.DbManager;
import com.company.model.entities.User;

import java.security.spec.ECField;
import java.sql.SQLException;
import java.util.List;

public class UsersService {

    private DbManager dbManager;

    public UsersService() throws Exception {
        try {
            dbManager = DbManager.getInstance();
        } catch (Exception e) {
            throw new Exception("Ошибка инициализации базы данных: " + e.getMessage());
        }
    }

    public List<User> getAllUsers() throws Exception {
        try {
            return dbManager.getTableUsers().getAllUsers();
        } catch (Exception e) {
            throw new Exception("Ошибка работы с базой данных: " + e.getMessage());
        }
    }

    public void addNewUser(User user) throws Exception{
        try {
            dbManager.getTableUsers().addNewUser(user);
        } catch (Exception e) {
            throw new Exception("Ошибка работы с базой данных: " + e.getMessage());
        }
    }
    public void deleteUser(int id) throws Exception{
try {
    dbManager.getTableUsers().deleteUser(id);
}catch (Exception e){
    throw new Exception("Ошибка удаления пользователя: "+e.getMessage());
}
    }
    public void updateUserFromAge(User user) throws Exception{
        try {
           dbManager.getTableUsers().updateUserFromAge(user);
        }catch (Exception e){
            throw new Exception("Ошибка изменения возраста пользователя: "+e.getMessage());
        }
    }
    public void updateUserFromName() throws Exception{

    }

}