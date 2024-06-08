package com.library;

public class Periodical extends Item {
    public static int count =0;
    public Periodical(String title) {
        super(title);
    }

    @Override
    public void borrowItem() {
        throw new UnsupportedOperationException("Periodicals cannot be borrowed.");
    }
}