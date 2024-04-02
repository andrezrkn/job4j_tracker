package ru.job4j.tracker.action;

import ru.job4j.tracker.input.Input;
import ru.job4j.tracker.Item;
import ru.job4j.tracker.output.Output;
import ru.job4j.tracker.Tracker;

public class FindId implements UserAction {
    private final Output out;

    public FindId(Output out) {
        this.out = out;
    }

    @Override
    public String name() {
        return "=== Find item by id ====";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        int id = input.askInt("Enter id: ");
        Item itemFind = tracker.findById(id);
        if (itemFind == null) {
            out.println("No item found.");
        } else {
            out.println("Name: " + itemFind.getName());
        }
        return true;
    }
}
