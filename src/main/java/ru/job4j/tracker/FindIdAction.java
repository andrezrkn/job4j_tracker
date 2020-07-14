package ru.job4j.tracker;

public class FindIdAction implements UserAction {
    @Override
    public String name() {
        return "=== Find item by id ====";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        int id = input.askInt("Enter id: ");
        Item itemFind = tracker.findById(id);
        if (itemFind == null) {
            System.out.println("No item found.");
        } else {
            System.out.println("Name: " + itemFind.getName());
        }
        return true;
    }
}
