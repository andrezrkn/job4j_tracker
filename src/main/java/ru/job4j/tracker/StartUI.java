package ru.job4j.tracker;



public class StartUI {
    public void init(Input input, Tracker tracker, UserAction[] actions) {
        boolean run = true;
        while (run) {
            this.showMenu(actions);
            int select = input.askInt("Select: ");
            while (select < 0 || select > 6) {
                select = input.askInt("Select an existing menu item ");
            }
            UserAction action = actions[select];
            run = action.execute(input, tracker);
        }
    }

    private void showMenu(UserAction[] actions) {
        System.out.println("Menu");
        for (int i = 0; i < actions.length; i++) {
            System.out.println(i + ". " + actions[i].name());
        }
    }

    public static void main(String[] args) {
        Tracker tracker = new Tracker();
        Input input =  new ConsoleInput();
        UserAction[] actions = {
                new CreateAction(),
                new DeleteAction(),
                new EditAction(),
                new ShowAction(),
                new FindIdAction(),
                new FindNameAction(),
                new ExitAction()
        };
        new StartUI().init(input, tracker, actions);
    }
}
