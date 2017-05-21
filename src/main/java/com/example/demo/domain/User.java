package com.example.demo.domain;


public class User {
    private String name;
    private String password;
    private int id;


    public User(String name, String password, int id) {
        this.name = name;
        this.password = password;
        this.id=id;

    }
    public User(){

    }



    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id=id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
