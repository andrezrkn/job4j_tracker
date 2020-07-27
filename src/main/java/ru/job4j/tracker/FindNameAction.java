package ru.job4j.tracker;

import java.util.List;

public class FindNameAction implements UserAction {
    private final Output out;

    public FindNameAction(Output out) {
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
