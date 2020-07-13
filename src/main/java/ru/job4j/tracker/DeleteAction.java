package ru.job4j.tracker;

public class DeleteAction implements UserAction {
    @Override
    public String name() {
        return "=== Delete Item ====";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        boolean result;
        int idEdit = input.askInt("Enter id: ");
        String nameEdit = input.askStr("Enter new name: ");
        Item itemEdit = new Item(nameEdit);
        result = tracker.replace(idEdit, itemEdit);
        if (result) {
            System.out.println("Successful edit");
        } else {
            System.out.println("Error edit");
        }
        return true;
    }
}
