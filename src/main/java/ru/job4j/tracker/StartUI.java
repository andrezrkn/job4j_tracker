package ru.job4j.tracker;

import java.util.Scanner;

public class StartUI {
    private Item[] itemMass = new Item[100];

    public void init(Scanner scanner, Tracker tracker) {
        boolean run = true;
        boolean result;
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
                    String nameCreate  = scanner.nextLine();
                    Item item = new Item(nameCreate);
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
                    int idEdit = Integer.valueOf(scanner.nextLine());
                    System.out.print("Enter new name: ");
                    String nameEdit = scanner.nextLine();
                    Item itemEdit = new Item(nameEdit);
                    result = tracker.replace(idEdit, itemEdit);
                    if (result) {
                        System.out.println("Successful edit");
                    } else {
                        System.out.println("Error edit");
                    }

                    break;
                case 3:
                    System.out.println("=== Delete Item ====");
                    System.out.print("Enter id: ");
                    int idDelete = Integer.valueOf(scanner.nextLine());
                    result = tracker.delete(idDelete);
                    if (result) {
                        System.out.println("Successful delete");
                    } else {
                        System.out.println("Error delete");
                    }
                    break;
                case 4:
                    System.out.println("=== Find item by id ====");
                    System.out.print("Enter id: ");
                    int idFind = Integer.valueOf(scanner.nextLine());
                    Item itemFind = tracker.findById(idFind);
                    if (itemFind == null) {
                        System.out.println("No item found.");
                    } else {
                        System.out.println("Name: " + itemFind.getName());
                    }
                    break;
                case 5:
                    System.out.println("=== Find items by name ====");
                    System.out.print("Enter name: ");
                    String nameItems = scanner.nextLine();
                    itemMass = tracker.findByName(nameItems);
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
