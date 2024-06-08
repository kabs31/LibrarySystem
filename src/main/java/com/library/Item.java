package com.library;

public abstract class Item {
    private String title;
    private int ID=0;

    private static int counter = 0;
    private boolean borrowed;

    public Item(String title) {
        this.ID = ++counter;
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
        if(this.borrowed){
            throw new UnsupportedOperationException("Item is already borrowed!");
        }
        this.borrowed = true;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public static int getCounter() {
        return counter;
    }

    public static void setCounter(int counter) {
        Item.counter = counter;
    }

    public void setBorrowed(boolean borrowed) {
        this.borrowed = borrowed;
    }

    public void returnItem() {
        if(this.borrowed){
            this.borrowed = false;
        }else{
            throw new UnsupportedOperationException("Item is already borrowed!");
        }

    }
    public static int getCounter(Class<?> clazz) {
        try {
            return clazz.getDeclaredField("count").getInt(null);
        } catch (NoSuchFieldException | IllegalAccessException e) {
            e.printStackTrace();
            return -1;
        }
    }
}
