package ru.job4j.tracker;

public class ShowAction implements UserAction {
    @Override
    public String name() {
        return "=== Show all items ====";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        Item[] itemMass = tracker.findAll();
        for (int index = 0; index < itemMass.length; index++) {
            System.out.println("id: " + itemMass[index].getId());
            System.out.println("name: " + itemMass[index].getName());
        }
        return true;
    }
}
