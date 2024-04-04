package ru.job4j.tracker.action;

import ru.job4j.tracker.input.Input;
import ru.job4j.tracker.Item;
import ru.job4j.tracker.output.Output;
import ru.job4j.tracker.Tracker;

public class EditAction implements UserAction {
    private final Output out;

    public EditAction(Output out) {
        this.out = out;
    }

    @Override
    public String name() {
        return "=== Edit item ====";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        boolean result;
        int idEdit = input.askInt("Enter id: ");
        String nameEdit = input.askStr("Enter new name: ");
        Item itemEdit = new Item(nameEdit);
        result = tracker.replace(idEdit, itemEdit);
        if (result) {
            out.println("Successful edit");
        } else {
            out.println("Error edit");
        }
        return true;
    }
}
