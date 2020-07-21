package ru.job4j.tracker;

public class StartUI {
    private final Output out;

    public StartUI(Output out) {
        this.out = out;
    }

    public void init(Input input, Tracker tracker, UserAction[] actions) {
        boolean run = true;
        while (run) {
            this.showMenu(actions);
            int select = input.askInt("Select: ");
            while (select < 0 || select >= actions.length) {
                select = input.askInt("Select an existing menu item ");
            }
            UserAction action = actions[select];
            run = action.execute(input, tracker);
        }
    }

    private void showMenu(UserAction[] actions) {
        out.println("Menu");
        for (int i = 0; i < actions.length; i++) {
            out.println(i + ". " + actions[i].name());
        }
    }

    public static void main(String[] args) {
        Output output = new ConsoleOutput();
        Tracker tracker = new Tracker();
        Input input =  new ValidateInput(output, new ConsoleInput());
        UserAction[] actions = {
                new CreateAction(),
                new DeleteAction(output),
                new EditAction(output),
                new ShowAction(output),
                new FindIdAction(output),
                new FindNameAction(output),
                new ExitAction()
        };
        new StartUI(output).init(input, tracker, actions);
    }
}
