package ru.job4j.tracker;

import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class StartUI {
    private final Output out;

    public StartUI(Output out) {
        this.out = out;
    }

    public void init(Input input, Tracker tracker, List<UserAction> actions) {
        boolean run = true;
        while (run) {
            this.showMenu(actions);
            int select = input.askInt("Select: ");
            while (select < 0 || select > actions.size() - 1) {
                select = input.askInt("Select an existing menu item ");
            }
            UserAction action = actions.get(select);
            run = action.execute(input, tracker);
        }
    }

    private void showMenu(List<UserAction> actions) {
        out.println("Menu");
        for (int i = 0; i < actions.size(); i++) {
            out.println(i + ". " + actions.get(i).name());
        }
    }

    public static void main(String[] args) {
        Item item = new Item();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MMMM-EEEE-yyyy HH:mm:ss");
        System.out.println(item.getDateTime().format(formatter));
        Output output = new ConsoleOutput();
        Tracker tracker = new Tracker();
        Input input =  new ValidateInput(output, new ConsoleInput());
        List<UserAction> actions = new ArrayList<UserAction>();
        actions.add(0, new CreateAction());
        actions.add(1, new DeleteAction(output));
        actions.add(2, new EditAction(output));
        actions.add(3, new ShowAction(output));
        actions.add(4, new FindIdAction(output));
        actions.add(5, new FindNameAction(output));
        actions.add(6, new ExitAction());
        new StartUI(output).init(input, tracker, actions);
    }
}
