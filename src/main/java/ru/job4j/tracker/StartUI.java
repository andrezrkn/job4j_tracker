package ru.job4j.tracker;

public class StartUI {
    private Item[] itemMass = new Item[100];

    public void init(Input input, Tracker tracker) {
        boolean run = true;
        boolean result;
        while (run) {
            this.showMenu();
            int select = input.askInt("");
            while (select < 0 || select > 6) {
                select = input.askInt("Select an existing menu item ");
            }
            switch (select) {
                case 0:
                    String nameCreate  = input.askStr("=== Create a new item ====\nEnter name: ");
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
                    int idEdit = input.askInt("=== Edit item ====\nEnter id: ");
                    String nameEdit = input.askStr("Enter new name: ");
                    Item itemEdit = new Item(nameEdit);
                    result = tracker.replace(idEdit, itemEdit);
                    if (result) {
                        System.out.println("Successful edit");
                    } else {
                        System.out.println("Error edit");
                    }

                    break;
                case 3:
                    int idDelete = input.askInt("=== Delete Item ====\nEnter id: ");
                    result = tracker.delete(idDelete);
                    if (result) {
                        System.out.println("Successful delete");
                    } else {
                        System.out.println("Error delete");
                    }
                    break;
                case 4:
                    int idFind = input.askInt("=== Find item by id ====\nEnter id: ");
                    Item itemFind = tracker.findById(idFind);
                    if (itemFind == null) {
                        System.out.println("No item found.");
                    } else {
                        System.out.println("Name: " + itemFind.getName());
                    }
                    break;
                case 5:
                    String nameItems = input.askStr("=== Find items by name ====\nEnter name: ");
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
        Tracker tracker = new Tracker();
        Input input =  new ConsoleInput();
        new StartUI().init(input, tracker);
    }
}
