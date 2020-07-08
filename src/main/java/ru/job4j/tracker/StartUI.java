package ru.job4j.tracker;

public class StartUI {
    public static void main(String[] args) {
        Tracker tracker = new Tracker();
        Item item = new Item();
        item.setName("trololo");
        tracker.add(item);
        item = tracker.findById(1);
        System.out.println(item.getId());
        System.out.println(item.getName());
    }
}
