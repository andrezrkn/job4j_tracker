package ru.job4j.tracker;

import org.junit.Test;
import ru.job4j.tracker.action.*;
import ru.job4j.tracker.input.Input;
import ru.job4j.tracker.input.StubInput;
import ru.job4j.tracker.input.ValidateInput;
import ru.job4j.tracker.output.ConsoleOutput;
import ru.job4j.tracker.output.Output;
import ru.job4j.tracker.output.StubOutput;
import ru.job4j.tracker.sort.AscendingSort;
import ru.job4j.tracker.sort.DescendingSort;

import static org.hamcrest.Matchers.is;
import static org.hamcrest.core.IsNull.nullValue;
import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

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
        List<Item> created = tracker.findAll();
        Item expected = new Item("Fix PC");
        assertThat(created.get(0).getName(), is(expected.getName()));
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
        List<UserAction> actions = new ArrayList<>();
          actions.add(0, new CreateAction());
          actions.add(1, new ExitAction());
        new StartUI(out).init(in, tracker, actions);
        assertThat(tracker.findAll().get(0).getName(), is("Item name"));
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
        List<UserAction> actions = new ArrayList<>();
        actions.add(0, new DeleteAction(output));
        actions.add(1, new ExitAction());
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
        /* Входные данные должны содержать ID добавленной заявки
        item.getId() */
        String replacedName = "New item name";
        Input in = new StubInput(
                new String[] {"0", "1", replacedName, "1"}
        );
        List<UserAction> actions = new ArrayList<>();
        actions.add(0, new EditAction(output));
        actions.add(1, new ExitAction());
        new StartUI(out).init(in, tracker, actions);
        assertThat(tracker.findAll().get(0).getName(), is(replacedName));
    }

    @Test
    public void whenExit() {
        Output out = new StubOutput();
        Input in = new StubInput(
                new String[] {"0"}
        );
        Tracker tracker = new Tracker();
        List<UserAction> actions = new ArrayList<>();
        actions.add(0, new ExitAction());
        new StartUI(out).init(in, tracker, actions);
        assertThat(out.toString(), is(
                "Menu" + System.lineSeparator()
                        + "0. === Exit ====" + System.lineSeparator()
        ));
    }

    @Test
    public void whenFindByName() {
        Output out = new StubOutput();
        Input in = new StubInput(
                new String[] {"0", "1", "0", "1", "1", "1", "2"}
        );
        Tracker tracker = new Tracker();
        List<UserAction> actions = new ArrayList<>();
        actions.add(0, new CreateAction());
        actions.add(1, new FindNameAction(out));
        actions.add(2, new ExitAction());
        new StartUI(out).init(in, tracker, actions);
        assertThat(out.toString(), is(
                "Menu" + System.lineSeparator()
                        + "0. === Create a new Item ====" + System
                        .lineSeparator()
                        + "1. === Find items by name ====" + System
                        .lineSeparator()
                        + "2. === Exit ====" + System.lineSeparator()
                        + "Menu" + System.lineSeparator()
                        + "0. === Create a new Item ====" + System
                        .lineSeparator()
                        + "1. === Find items by name ====" + System
                        .lineSeparator()
                        + "2. === Exit ====" + System.lineSeparator()
                        + "Menu" + System.lineSeparator()
                        + "0. === Create a new Item ====" + System
                        .lineSeparator()
                        + "1. === Find items by name ====" + System
                        .lineSeparator()
                        + "2. === Exit ====" + System.lineSeparator()
                        + "id: 1" + System.lineSeparator()
                        + "id: 2" + System.lineSeparator()
                        + "Menu" + System.lineSeparator()
                        + "0. === Create a new Item ====" + System
                        .lineSeparator()
                        + "1. === Find items by name ====" + System
                        .lineSeparator()
                        + "2. === Exit ====" + System.lineSeparator()

        ));
    }

    @Test
    public void whenFindById() {
        Output out = new StubOutput();
        Input in = new StubInput(
                new String[] {"0", "1", "0", "2", "1", "1", "2"}
        );
        Tracker tracker = new Tracker();
        List<UserAction> actions = new ArrayList<>();
        actions.add(0, new CreateAction());
        actions.add(1, new FindIdAction(out));
        actions.add(2, new ExitAction());
        new StartUI(out).init(in, tracker, actions);
        assertThat(out.toString(), is(
                "Menu" + System.lineSeparator()
                        + "0. === Create a new Item ====" + System
                        .lineSeparator()
                        + "1. === Find item by id ====" + System
                        .lineSeparator()
                        + "2. === Exit ====" + System.lineSeparator()
                        + "Menu" + System.lineSeparator()
                        + "0. === Create a new Item ====" + System
                        .lineSeparator()
                        + "1. === Find item by id ====" + System
                        .lineSeparator()
                        + "2. === Exit ====" + System
                        .lineSeparator()
                        + "Menu" + System.lineSeparator()
                        + "0. === Create a new Item ====" + System
                        .lineSeparator()
                        + "1. === Find item by id ====" + System
                        .lineSeparator()
                        + "2. === Exit ====" + System.lineSeparator()
                        + "Name: 1" + System.lineSeparator()
                        + "Menu" + System.lineSeparator()
                        + "0. === Create a new Item ====" + System
                        .lineSeparator()
                        + "1. === Find item by id ====" + System
                        .lineSeparator()
                        + "2. === Exit ====" + System.lineSeparator()

        ));
    }

    @Test
    public void whenShowAction() {
        Output out = new StubOutput();
        Input in = new StubInput(
                new String[] {"0", "1", "0", "2", "1", "2"}
        );
        Tracker tracker = new Tracker();
        List<UserAction> actions = new ArrayList<>();
        actions.add(0, new CreateAction());
        actions.add(1, new ShowAction(out));
        actions.add(2, new ExitAction());
        new StartUI(out).init(in, tracker, actions);
        assertThat(out.toString(), is(
                "Menu" + System.lineSeparator()
                        + "0. === Create a new Item ====" + System
                        .lineSeparator()
                        + "1. === Show all items ====" + System.lineSeparator()
                        + "2. === Exit ====" + System.lineSeparator()
                        + "Menu" + System.lineSeparator()
                        + "0. === Create a new Item ====" + System
                        .lineSeparator()
                        + "1. === Show all items ====" + System.lineSeparator()
                        + "2. === Exit ====" + System.lineSeparator()
                        + "Menu" + System.lineSeparator()
                        + "0. === Create a new Item ====" + System
                        .lineSeparator()
                        + "1. === Show all items ====" + System.lineSeparator()
                        + "2. === Exit ====" + System.lineSeparator()
                        + "Item{id=1, name='1'}" + System.lineSeparator()
                        + "Item{id=2, name='2'}" + System.lineSeparator()
                        + "Menu" + System.lineSeparator()
                        + "0. === Create a new Item ====" + System
                        .lineSeparator()
                        + "1. === Show all items ====" + System.lineSeparator()
                        + "2. === Exit ====" + System.lineSeparator()

        ));
    }

    @Test
    public void whenInvalidExit() {
        Output out = new StubOutput();
        Input in = new StubInput(
                new String[] {"1", "0"}
        );
        Tracker tracker = new Tracker();
        List<UserAction> actions = new ArrayList<>();
        actions.add(0, new ExitAction());
        new StartUI(out).init(in, tracker, actions);
        assertThat(out.toString(), is(
                        "Menu" + System.lineSeparator()
                                + "0. === Exit ====" + System.lineSeparator()

        ));
    }

    @Test
    public void whenInvalidInput() {
        Output out = new StubOutput();
        Input in = new StubInput(
                new String[] {"one", "1"}
        );
        ValidateInput input = new ValidateInput(out, in);
        int selected = input.askInt("Enter menu:");
        assertThat(selected, is(1));
    }

    @Test
    public void whenTrueInput() {
        Output out = new StubOutput();
        Input in = new StubInput(
                new String[] {"1", "2"}
        );
        ValidateInput input = new ValidateInput(out, in);
        int selected = input.askInt("Enter menu:");
        assertThat(selected, is(1));
    }

    @Test
    public void whenInvalidOutput() {
        Output out = new StubOutput();
        Input in = new StubInput(
                new String[] {"one", "1"}
        );
        ValidateInput input = new ValidateInput(out, in);
        int selected = input.askInt("Enter menu:");
        assertThat(out.toString(), is("Please enter validate data again."
                + System.lineSeparator()));
    }

    @Test
    public void whenAscendingSort() {
        List<Item> baseItems = Arrays.asList(
                    new Item(0, "0"),
                    new Item(2, "2"),
                    new Item(1, "1")
        );
        List<Item> expectedItems = Arrays.asList(
                new Item(0, "0"),
                new Item(1, "1"),
                new Item(2, "2")
        );
        baseItems = AscendingSort.sort(baseItems);
        assertTrue(baseItems.equals(expectedItems));
    }

    @Test
    public void whenDescendingSort() {
        List<Item> baseItems = Arrays.asList(
                new Item(0, "0"),
                new Item(2, "2"),
                new Item(1, "1")
        );
        List<Item> expectedItems = Arrays.asList(
                new Item(2, "2"),
                new Item(1, "1"),
                new Item(0, "0")
        );
        baseItems = DescendingSort.sort(baseItems);
        assertTrue(baseItems.equals(expectedItems));
    }
}