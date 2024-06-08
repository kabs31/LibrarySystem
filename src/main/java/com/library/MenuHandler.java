package com.library;

import java.util.Scanner;

public class MenuHandler {
        private static Library library = Library.createLibrary();
        private static Scanner scanner = new Scanner(System.in);

        public static void run() {
            System.out.println( "-----------LIBRARY MANAGEMENT SYSTEM----------" );
            boolean exit = false;

            while (!exit) {
                printMenu();
                int choice = scanner.nextInt();
                scanner.nextLine(); // Consume newline

                switch (choice) {
                    case 1:
                        addItem();
                        break;
                    case 2:
                        removeItem();
                        break;
                    case 3:
                        borrowItem();
                        break;
                    case 4:
                        returnItem();
                        break;
                    case 5:
                        displayItems();
                        break;
                    case 6:
                        exit = true;
                        break;
                    default:
                        System.out.println("Invalid choice. Please try again.");
                }
            }

            scanner.close();
        }

        private static void printMenu() {
            System.out.println("\nLibrary Menu:");
            System.out.println("1. Add Item");
            System.out.println("2. Remove Item");
            System.out.println("3. Borrow Item");
            System.out.println("4. Return Item");
            System.out.println("5. Display All Items");
            System.out.println("6. Exit");
            System.out.print("Enter your choice: ");
        }

        private static void addItem() {
            System.out.println("Choose item type to add:");
            System.out.println("1. Book");
            System.out.println("2. CD");
            System.out.println("3. DVD");
            System.out.println("4. Periodical");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            System.out.print("Enter title: ");
            String title = scanner.nextLine();

            try {
                switch (choice) {
                    case 1:
                        library.addItem(new Book(title));
                        break;
                    case 2:
                        library.addItem(new CD(title));
                        break;
                    case 3:
                        library.addItem(new DVD(title));
                        break;
                    case 4:
                        library.addItem(new Periodical(title));
                        break;
                    default:
                        System.out.println("Invalid item type. Item not added.");
                }
            } catch (Exception e) {
                System.out.println("Exception occurred: " + e.getMessage());
            }
        }

        private static void removeItem() {
            System.out.print("Enter item ID to remove: ");
            int id = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            Item item = findItemById(id);
            try {
                library.removeItem(item);
            } catch (Exception e) {
                System.out.println("Exception occurred: " + e.getMessage());
            }
        }

        private static void borrowItem() {
            System.out.print("Enter item ID to borrow: ");
            int id = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            Item item = findItemById(id);
            try {
                library.borrowItem(item);
            } catch (Exception e) {
                System.out.println("Exception occurred: " + e.getMessage());
            }
        }

        private static void returnItem() {
            System.out.print("Enter item ID to return: ");
            int id = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            Item item = findItemById(id);
            try {
                library.returnItem(item);
            } catch (Exception e) {
                System.out.println("Exception occurred: " + e.getMessage());
            }
        }

        private static void displayItems() {
            library.displayItems();
        }

        private static Item findItemById(int id) {
            for (Item item : library.getItems()) {
                if (item.getID() == id) {
                    return item;
                }
            }
            return null;
        }
}


