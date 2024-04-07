package ru.job4j.tracker;

import java.util.List;

public final class SingleTracker {

    private static Tracker tracker = new Tracker();

    private SingleTracker() {
    }

    public static Tracker getTracker() {
        if (tracker == null) {
            tracker = new Tracker();
        }
        return tracker;
    }

    public boolean delete(int id) {
        return tracker.delete(id);
    }

    public Item add(Item item) {
        return tracker.add(item);
    }

    public boolean replace(int id, Item item) {
        return tracker.replace(id, item);
    }

    public Item findById(int id) {
        return tracker.findById(id);
    }

    public List<Item> findAll() {
        return tracker.findAll();
    }

    public List<Item> findByName(String key) {
        return tracker.findByName(key);
    }
}
