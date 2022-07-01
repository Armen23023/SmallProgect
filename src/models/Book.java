package models;

import models.User;

public class Book   {
        private String  name;
         private int year;
         private int  pageCount;
         private User author;

    public void setName(String name) {
        this.name = name;
    }

    public void setPageCount(int pageCount) {
        this.pageCount = pageCount;
    }

    public void setAuthor(User author) {
        this.author = author;
    }
    public Book(){};

    public User getAuthor() {
        return author;
    }

    public Book(String name, int pageCount, int year, User author) {
        this.name = name;
        this.pageCount = pageCount;
        this.author = author;
        this.year = year;
    }

    @Override
    public String toString() {
        return
                " name: " + name  +
                " pageCount: " + pageCount +
                " author: " + author +
                " year: "+ year;
    }
}