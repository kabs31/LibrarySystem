package com.library;

public abstract class Item {
    private String title;
    private boolean borrowed;

    public Item(String title) {
        this.title = title;
        this.borrowed = false;
    }

    public String getTitle() {
        return title;
    }

    public boolean isBorrowed() {
        return borrowed;
    }

    public void borrowItem() {
        this.borrowed = true;
    }

    public void returnItem() {
        this.borrowed = false;
    }
}
