package ru.job4j.tracker;

public class DeleteAction implements UserAction {
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
            System.out.println("Successful delete");
        } else {
            System.out.println("Error delete");
        }
        return true;
    }
}
