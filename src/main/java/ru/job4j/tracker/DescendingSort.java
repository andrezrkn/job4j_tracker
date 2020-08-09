package ru.job4j.tracker;

import java.util.Collections;
import java.util.List;

public class DescendingSort {
    public static List<Item> sort(List<Item> mass) {
        Collections.sort(mass, Collections.reverseOrder());
        return mass;
    }
}