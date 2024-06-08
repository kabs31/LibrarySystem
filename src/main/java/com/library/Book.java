package com.library;

public class Book extends Item {

    public static int count =0;
    public Book(String title) {
        super(title);
        count++;
    }
}