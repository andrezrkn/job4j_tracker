package ru.job4j.tracker;

public class CreateAction implements UserAction {
    @Override
    public String name() {
        return "=== Create a new Item ====";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        String nameCreate  = input.askStr("Enter name: ");
        Item item = new Item(nameCreate);
        tracker.add(item);
        return true;
    }
}
