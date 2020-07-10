package ru.job4j.tracker;

import java.util.Scanner;

public class StartUI {
    private Item[] itemMass = new Item[100];

    public void init(Scanner scanner, Tracker tracker) {
        int id;
        int i;
        Item item = new Item();
        String name;
        boolean run = true;
        while (run) {
            this.showMenu();
            int select = Integer.valueOf(scanner.nextLine());
            while (select < 0 || select > 6) {
                System.out.println("Select an existing menu item ");
                select = Integer.valueOf(scanner.nextLine());
            }
            switch (select) {
                case 0:
                    System.out.println("=== Create a new item ====");
                    System.out.print("Enter name: ");
                    name = scanner.nextLine();
                    item = new Item(name);
                    tracker.add(item);
                    break;
                case 1:
                    System.out.println("=== Show all items ====");
                    itemMass = tracker.findAll();
                    for (int index = 0; index < itemMass.length; index++) {
                        System.out.println("id: " + itemMass[index].getId());
                        System.out.println("name: " + itemMass[index].getName());
                    }
                    break;
                case 2:
                    System.out.println("=== Edit item ====");
                    System.out.print("Enter id: ");
                    id = Integer.valueOf(scanner.nextLine());
                    System.out.print("Enter new name: ");
                    name = scanner.nextLine();
                    item.setName(name);
                    tracker.replace(id, item);

                    break;
                case 3:
                    System.out.println("=== Delete Item ====");
                    System.out.print("Enter id: ");
                    id = Integer.valueOf(scanner.nextLine());
                    boolean result = tracker.delete(id);
                    if (result) {
                        System.out.println("Successful delete");
                    } else {
                        System.out.println("Error delete");
                    }
                    break;
                case 4:
                    System.out.println("=== Find item by id ====");
                    System.out.print("Enter id: ");
                    id = Integer.valueOf(scanner.nextLine());
                    item = tracker.findById(id);
                    if (item == null) {
                        System.out.println("No item found.");
                    } else {
                        System.out.println("Name: " + item.getName());
                    }
                    break;
                case 5:
                    System.out.println("=== Find items by name ====");
                    System.out.print("Enter name: ");
                    name = scanner.nextLine();
                    itemMass = tracker.findByName(name);
                        for (int j = 0; j < itemMass.length; j++) {
                            System.out.println(itemMass[j].getId());
                        }
                    break;
                case 6: run = false;
            }
        }
    }

    private void showMenu() {
        System.out.println("Menu");
        System.out.println("0. Add new item");
        System.out.println("1. Show all items");
        System.out.println("2. Edit item");
        System.out.println("3. Delete item");
        System.out.println("4. Find item by id");
        System.out.println("5. Find items by name");
        System.out.println("6. Exit program");
        System.out.println("Select: ");

    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Tracker tracker = new Tracker();
        new StartUI().init(scanner, tracker);
    }
}
