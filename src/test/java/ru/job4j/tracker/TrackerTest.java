package ru.job4j.tracker;

import org.junit.Test;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertNull;
import static org.hamcrest.core.IsNull.nullValue;

public class TrackerTest {
    @Test
    public void whenAddNewItemThenTrackerHasSameItem() {
        Tracker tracker = new Tracker();
        Item item = new Item();
        item.setName("test1");
        tracker.add(item);
        Item result = tracker.findById(item.getId());
        assertThat(result.getName(), is(item.getName()));
    }

    @Test
    public void whenReplace() {
        Tracker tracker = new Tracker();
        Item bug = new Item();
        bug.setName("Bug");
        tracker.add(bug);
        int id = bug.getId();
        Item bugWithDesc = new Item();
        bugWithDesc.setName("Bug with description");
        tracker.replace(id, bugWithDesc);
        assertThat(tracker.findById(id).getName(), is("Bug with description"));
    }

    @Test
    public void whenDelete() {
        Tracker tracker = new Tracker();
        Item bug = new Item();
        bug.setName("Bug");
        tracker.add(bug);
        int id = bug.getId();
        tracker.delete(id);
        assertThat(tracker.findById(id), is(nullValue()));
    }

    @Test
    public void whenAddItem() {
        String[] answers = {"Fix PC"};
        Input input = new StubInput(answers);
        Tracker tracker = new Tracker();
        new CreateAction().execute(input, tracker);
        Item created = tracker.findAll()[0];
        Item expected = new Item("Fix PC");
        assertThat(created.getName(), is(expected.getName()));
    }

    @Test
    public void whenReplaceItem() {
        Output out = new StubOutput();
        Tracker tracker = new Tracker();
        Item item = new Item("new item");
        tracker.add(item);
        String[] answers = {
                String.valueOf(item.getId()),
                "replaced item"
        };
        new EditAction(out).execute(new StubInput(answers), tracker);
        Item replaced = tracker.findById(item.getId());
        assertThat(replaced.getName(), is("replaced item"));
    }

    @Test
    public void whenDeleteItem() {
        Output out = new StubOutput();
        Tracker tracker = new Tracker();
        Item item = new Item("lol");
        tracker.add(item);
        String[] info = {
                String.valueOf(item.getId()),
                item.getName()
        };
        new DeleteAction(out).execute(new StubInput(info), tracker);
        Item deleted = tracker.findById(item.getId());
        assertNull(deleted);
    }

    @Test
    public void whenCreateItem() {
        Output out = new StubOutput();
        Input in = new StubInput(
                new String[] {"0", "Item name", "1"}
        );
        Tracker tracker = new Tracker();
        UserAction[] actions = {
          new CreateAction(),
          new ExitAction()
        };
        new StartUI(out).init(in, tracker, actions);
        assertThat(tracker.findAll()[0].getName(), is("Item name"));
    }

    @Test
    public void whenDeleteAction() {
        Output out = new StubOutput();
        Output output = new ConsoleOutput();
        Tracker tracker = new Tracker();
        Item item = tracker.add(new Item("Deleted item"));
        Input in = new StubInput(
                new String[] {"0", "1", "1"}
        );
        UserAction[] actions = {
                new DeleteAction(output),
                new ExitAction()
        };
        new StartUI(out).init(in, tracker, actions);
        assertNull(tracker.findById(item.getId()));
    }

    @Test
    public void whenEditAction() {
        Output output = new ConsoleOutput();
        Output out = new StubOutput();
        Tracker tracker = new Tracker();
        /* Добавим в tracker новую заявку */
        Item item = tracker.add(new Item("Replaced item"));
        /* Входные данные должны содержать ID добавленной заявки item.getId() */
        String replacedName = "New item name";
        Input in = new StubInput(
                new String[] {"0", "1", replacedName, "1"}
        );
        UserAction[] actions = {
                new EditAction(output),
                new ExitAction()
        };
        new StartUI(out).init(in, tracker, actions);
        assertThat(tracker.findAll()[0].getName(), is(replacedName));
    }

    @Test
    public void whenExit() {
        Output out = new StubOutput();
        Input in = new StubInput(
                new String[] {"0"}
        );
        Tracker tracker = new Tracker();
        UserAction[] actions = {
                new ExitAction()
        };
        new StartUI(out).init(in, tracker, actions);
        assertThat(out.toString(), is(
                "Menu" + System.lineSeparator() +
                        "0. === Exit ====" + System.lineSeparator()
        ));
    }

    @Test
    public void whenFindByName() {
        Output output = new ConsoleOutput();
        Output out = new StubOutput();
        Input in = new StubInput(
                new String[] {"0", "1", "0", "1", "1", "1", "2"}
        );
        Tracker tracker = new Tracker();
        UserAction[] actions = {
                new CreateAction(),
                new FindNameAction(output),
                new ExitAction()
        };
        new StartUI(out).init(in, tracker, actions);
        assertThat(out.toString(), is(
                "Menu" + System.lineSeparator() +
                        "0. === Create a new Item ====" + System.lineSeparator() +
                        "1. === Find items by name ====" + System.lineSeparator() +
                        "2. === Exit ====" + System.lineSeparator() +
                        "Menu" + System.lineSeparator() +
                        "0. === Create a new Item ====" + System.lineSeparator() +
                        "1. === Find items by name ====" + System.lineSeparator() +
                        "2. === Exit ====" + System.lineSeparator() +
                        "Menu" + System.lineSeparator() +
                        "0. === Create a new Item ====" + System.lineSeparator() +
                        "1. === Find items by name ====" + System.lineSeparator() +
                        "2. === Exit ====" + System.lineSeparator() +
                        "Menu" + System.lineSeparator() +
                        "0. === Create a new Item ====" + System.lineSeparator() +
                        "1. === Find items by name ====" + System.lineSeparator() +
                        "2. === Exit ====" + System.lineSeparator()

        ));
    }

    @Test
    public void whenFindById() {
        Output output = new ConsoleOutput();
        Output out = new StubOutput();
        Input in = new StubInput(
                new String[] {"0", "1", "0", "2", "1", "1", "2"}
        );
        Tracker tracker = new Tracker();
        UserAction[] actions = {
                new CreateAction(),
                new FindIdAction(output),
                new ExitAction()
        };
        new StartUI(out).init(in, tracker, actions);
        assertThat(out.toString(), is(
                "Menu" + System.lineSeparator() +
                        "0. === Create a new Item ====" + System.lineSeparator() +
                        "1. === Find item by id ====" + System.lineSeparator() +
                        "2. === Exit ====" + System.lineSeparator() +
                        "Menu" + System.lineSeparator() +
                        "0. === Create a new Item ====" + System.lineSeparator() +
                        "1. === Find item by id ====" + System.lineSeparator() +
                        "2. === Exit ====" + System.lineSeparator() +
                        "Menu" + System.lineSeparator() +
                        "0. === Create a new Item ====" + System.lineSeparator() +
                        "1. === Find item by id ====" + System.lineSeparator() +
                        "2. === Exit ====" + System.lineSeparator() +
                        "Menu" + System.lineSeparator() +
                        "0. === Create a new Item ====" + System.lineSeparator() +
                        "1. === Find item by id ====" + System.lineSeparator() +
                        "2. === Exit ====" + System.lineSeparator()

        ));
    }

    @Test
    public void whenShowAction() {
        Output output = new ConsoleOutput();
        Output out = new StubOutput();
        Input in = new StubInput(
                new String[] {"0", "1", "0", "2", "1", "2"}
        );
        Tracker tracker = new Tracker();
        UserAction[] actions = {
                new CreateAction(),
                new ShowAction(output),
                new ExitAction()
        };
        new StartUI(out).init(in, tracker, actions);
        assertThat(out.toString(), is(
                "Menu" + System.lineSeparator() +
                        "0. === Create a new Item ====" + System.lineSeparator() +
                        "1. === Show all items ====" + System.lineSeparator() +
                        "2. === Exit ====" + System.lineSeparator() +
                        "Menu" + System.lineSeparator() +
                        "0. === Create a new Item ====" + System.lineSeparator() +
                        "1. === Show all items ====" + System.lineSeparator() +
                        "2. === Exit ====" + System.lineSeparator() +
                        "Menu" + System.lineSeparator() +
                        "0. === Create a new Item ====" + System.lineSeparator() +
                        "1. === Show all items ====" + System.lineSeparator() +
                        "2. === Exit ====" + System.lineSeparator() +
                        "Menu" + System.lineSeparator() +
                        "0. === Create a new Item ====" + System.lineSeparator() +
                        "1. === Show all items ====" + System.lineSeparator() +
                        "2. === Exit ====" + System.lineSeparator()

        ));
    }
}