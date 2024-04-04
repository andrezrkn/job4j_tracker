package ru.job4j.tracker.sort;

import ru.job4j.tracker.Item;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class DescendingSort implements Comparator<Item> {
    public static List<Item> sort(List<Item> mass) {
        Collections.sort(mass, new DescendingSort());
        return mass;
    }

    @Override
    public int compare(Item first, Item second) {
        return second.getName().compareTo(first.getName());
    }
}