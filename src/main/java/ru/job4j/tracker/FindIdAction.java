package ru.job4j.tracker;

public class FindIdAction implements UserAction {
    private final Output out;

    public FindIdAction(Output out) {
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
