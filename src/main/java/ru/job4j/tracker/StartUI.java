package ru.job4j.tracker;

import ru.job4j.tracker.action.*;
import ru.job4j.tracker.input.Input;
import ru.job4j.tracker.input.Validate;
import ru.job4j.tracker.output.Console;
import ru.job4j.tracker.output.Output;

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
        DateTimeFormatter formatter = DateTimeFormatter
                .ofPattern("dd-MMMM-EEEE-yyyy HH:mm:ss");
        System.out.println(item.getDateTime().format(formatter));
        Output output = new Console();
        Tracker tracker = new Tracker();
        Input input =  new Validate(output, new ru.job4j.tracker.input.Console());
        List<UserAction> actions = new ArrayList<UserAction>();
        actions.add(0, new Create());
        actions.add(1, new Delete(output));
        actions.add(2, new Edit(output));
        actions.add(3, new Show(output));
        actions.add(4, new FindId(output));
        actions.add(5, new FindName(output));
        actions.add(6, new Exit());
        new StartUI(output).init(input, tracker, actions);
    }
}
