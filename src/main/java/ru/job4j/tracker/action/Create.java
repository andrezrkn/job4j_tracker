package ru.job4j.tracker.action;

import ru.job4j.tracker.input.Input;
import ru.job4j.tracker.Item;
import ru.job4j.tracker.Tracker;

public class Create implements UserAction {
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
