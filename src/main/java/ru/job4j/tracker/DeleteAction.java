package ru.job4j.tracker;

public class DeleteAction implements UserAction {
    private final Output out;

    public DeleteAction(Output out) {
        this.out = out;
    }

    @Override
    public String name() {
        return "=== Delete Item ====";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        boolean result;
        int id = input.askInt("Enter id: ");
        result = tracker.delete(id);
        if (result) {
            out.println("Successful delete");
        } else {
            out.println("Error delete");
        }
        return true;
    }
}
