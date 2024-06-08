package com.library;

import java.util.ArrayList;
import java.util.List;

public class Library {
    private static List<Item> items;
    private static Library library = null;

    public static List<Item> getItems() {
        return items;
    }

    public static void setItems(List<Item> items) {
        Library.items = items;
    }

    private Library() {
        this.items = new ArrayList<>();
    }

    //Singleton Object
    public static Library createLibrary(){
        if(library==null){
            library = new Library();
        }
        return library;
    }

    public static void addItem(Item item) {
        if(Item.getCounter(item.getClass())<6){
            items.add(item);
            System.out.println(item.getTitle()+" is Added with id: "+item.getID());
        }else{
            throw new UnsupportedOperationException("Library doesnt allow to add more than 6 numbers of same item type!");
        }

    }

    public static void removeItem(Item item) {
        if(!items.isEmpty()){
            items.remove(item);
            System.out.println(item.getTitle()+" is Removed with id: "+item.getID());
        }else{
            throw new UnsupportedOperationException("Remove cannot be performed as Library has no items in it!");
        }

    }

    public static void borrowItem(Item item) {
        try {
            item.borrowItem();
            System.out.println(item.getTitle()+" is Borrowed with id: "+item.getID());
        } catch (Exception e) {
            System.out.println("Exception: " + e.getMessage());
        }

    }

    public static void returnItem(Item item) {
        try {
            item.returnItem();
            System.out.println(item.getTitle()+" is Returned with id: "+item.getID());
        } catch (Exception e) {
            System.out.println("Exception: " + e.getMessage());
        }
    }

    public static void displayItems() {
        for (Item item : items) {
            System.out.println(item.getTitle() + " - " + (item.isBorrowed() ? "Borrowed" : "Available")+"---id: "+item.getID());
        }
    }
}
