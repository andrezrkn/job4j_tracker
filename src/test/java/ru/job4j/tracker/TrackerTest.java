package ru.job4j.tracker;

import org.junit.Test;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;
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
    public void whenRenameTrue() {
        Tracker tracker = new Tracker();
        String name = "1";
        Item item = new Item(name);
        tracker.add(item);
        name = "2";
        item = new Item(name);
        tracker.add(item);
        name = "3";
        item = new Item(name);
        tracker.add(item);
        int editId = 1;
        String editName = "5";
        item.setName(editName);
        boolean result = tracker.replace(editId, item);
        assertThat(tracker.findById(1).getId(), is(1));
        assertThat(tracker.findById(1).getName(), is("5"));
        assertThat(tracker.findById(2).getId(), is(2));
        assertThat(tracker.findById(2).getName(), is("2"));
        assertThat(tracker.findById(3).getId(), is(3));
        assertThat(tracker.findById(3).getName(), is("3"));
    }

}