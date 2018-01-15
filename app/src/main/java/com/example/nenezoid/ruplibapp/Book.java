package com.example.nenezoid.ruplibapp;

/**
 * Created by Nenezoid on 1/9/2018.
 */

public class Book {

    public int id;
    public String title,author;
    public boolean available;
    public String imageUrl;
    public Book(int id_, String title_, String author_, String url,boolean available_){
        this.id=id_;
        this.title=title_;
        this.author=author_;
        this.available=available_;
        imageUrl=url;
    }

    public Book(){}

    public String toString()
    {
        return "Title: "+title+"\nAuthor: "+author+"\nIs available: "+(available?"yes":"no");
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public boolean getAvailable() {
        return available;
    }
}
