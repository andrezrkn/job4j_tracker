package ru.job4j.tracker;

public class StartUI {
    private static Item[] itemMass = new Item[100];

    public static void createItem(Input input, Tracker tracker) {
        String nameCreate  = input.askStr("=== Create a new item ====\nEnter name: ");
        Item item = new Item(nameCreate);
        tracker.add(item);
    }

    public static void showItem(Tracker tracker) {
        System.out.println("=== Show all items ====");
        itemMass = tracker.findAll();
        for (int index = 0; index < itemMass.length; index++) {
            System.out.println("id: " + itemMass[index].getId());
            System.out.println("name: " + itemMass[index].getName());
        }
    }

    public static void editItem(Input input, Tracker tracker) {
        boolean result;
        int idEdit = input.askInt("=== Edit item ====\nEnter id: ");
        String nameEdit = input.askStr("Enter new name: ");
        Item itemEdit = new Item(nameEdit);
        result = tracker.replace(idEdit, itemEdit);
        if (result) {
            System.out.println("Successful edit");
        } else {
            System.out.println("Error edit");
        }
    }

    public static void deleteItem(Input input, Tracker tracker) {
        boolean result;
        int idDelete = input.askInt("=== Delete Item ====\nEnter id: ");
        result = tracker.delete(idDelete);
        if (result) {
            System.out.println("Successful delete");
        } else {
            System.out.println("Error delete");
        }
    }

    public static void findIdItem(Input input, Tracker tracker) {
        int idFind = input.askInt("=== Find item by id ====\nEnter id: ");
        Item itemFind = tracker.findById(idFind);
        if (itemFind == null) {
            System.out.println("No item found.");
        } else {
            System.out.println("Name: " + itemFind.getName());
        }
    }

    public static void findNameItems(Input input, Tracker tracker) {
        String nameItems = input.askStr("=== Find items by name ====\nEnter name: ");
        itemMass = tracker.findByName(nameItems);
        for (int j = 0; j < itemMass.length; j++) {
            System.out.println(itemMass[j].getId());
        }
    }

    public void init(Input input, Tracker tracker) {
        boolean run = true;
        while (run) {
            this.showMenu();
            int select = input.askInt("");
            while (select < 0 || select > 6) {
                select = input.askInt("Select an existing menu item ");
            }
            switch (select) {
                case 0:
                    StartUI.createItem(input, tracker);
                    break;
                case 1:
                    StartUI.showItem(tracker);
                    break;
                case 2:
                    StartUI.editItem(input, tracker);
                    break;
                case 3:
                    StartUI.deleteItem(input, tracker);
                    break;
                case 4:
                    StartUI.findIdItem(input, tracker);
                    break;
                case 5:
                    StartUI.findNameItems(input, tracker);
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
        Tracker tracker = new Tracker();
        Input input =  new ConsoleInput();
        new StartUI().init(input, tracker);
    }
}
