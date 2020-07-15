package ru.job4j.tracker;

public class ShowAction implements UserAction {
    private final Output out;

    public ShowAction(Output out) {
        this.out = out;
    }

    @Override
    public String name() {
        return "=== Show all items ====";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        Item[] itemMass = tracker.findAll();
        for (int index = 0; index < itemMass.length; index++) {
            out.println(itemMass[index]);
        }
        return true;
    }
}
