package com.example.demo.domain;

/**
 * Created by kraet on 16.05.2017.
 */
public class Book {
    private int userId;
    private String title;
    private String author;
    private int isn;
    private String isTakenBy;
    public Book(int userId,String title,String author,int isn,String isTakenBy){
        this.userId=userId;
        this.title=title;
        this.author=author;
        this.isn = isn;
        this.isTakenBy=isTakenBy;
    }
    public Book(){}

    public String getIsTakenBy() {
        return isTakenBy;
    }

    public void setIsTakenBy(String isTakenBy) {
        this.isTakenBy = isTakenBy;
    }

    public int getIsn() {
        return isn;
    }

    public void setIsn(int isn) {
        this.isn = isn;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }
}

