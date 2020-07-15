package ru.job4j.tracker;

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
        Item[] itemMass = tracker.findByName(nameItems);
        for (int j = 0; j < itemMass.length; j++) {
            out.println("id: " + itemMass[j].getId());
        }
        return true;
    }
}
