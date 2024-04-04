package ru.job4j.tracker.action;

import ru.job4j.tracker.input.Input;
import ru.job4j.tracker.output.Output;
import ru.job4j.tracker.Tracker;

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
