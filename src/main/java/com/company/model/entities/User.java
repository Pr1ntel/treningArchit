package com.company.model.entities;

public class User {
    private int id;
    private String name;
    private int age;
    private int countryId;

    public User(int id, String name, int age, int countryId) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.countryId = countryId;
    }

    public User(String name, int age, int countryId) {
        this.id = 0;
        this.name = name;
        this.age = age;
        this.countryId = countryId;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public int getCountryId() {
        return countryId;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", countryId=" + countryId +
                '}';
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }
}