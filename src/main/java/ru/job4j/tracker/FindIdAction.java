package ru.job4j.tracker;

public class FindIdAction implements UserAction {
    @Override
    public String name() {
        return "=== Find item by id ====";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        String nameItems = input.askStr("Enter name: ");
        Item[] itemMass = tracker.findByName(nameItems);
        for (int j = 0; j < itemMass.length; j++) {
            System.out.println(itemMass[j].getId());
        }
        return true;
    }
}
