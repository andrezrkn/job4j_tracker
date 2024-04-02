package ru.job4j.tracker.action;

import ru.job4j.tracker.input.Input;
import ru.job4j.tracker.Item;
import ru.job4j.tracker.output.Output;
import ru.job4j.tracker.Tracker;

import java.util.List;

public class FindName implements UserAction {
    private final Output out;

    public FindName(Output out) {
        this.out = out;
    }

    @Override
    public String name() {
        return "=== Find items by name ====";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        String nameItems  = input.askStr("Enter name: ");
        List<Item> itemMass = tracker.findByName(nameItems);
        for (Item item : itemMass) {
            out.println("id: " + item.getId());
        }
        return true;
    }
}
