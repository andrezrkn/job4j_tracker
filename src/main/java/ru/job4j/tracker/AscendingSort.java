package ru.job4j.tracker;

import java.util.Collections;
import java.util.List;

public class AscendingSort {
    public static List<Item> sort(List<Item> mass) {
        Collections.sort(mass, new SortByNameItem());
        return mass;
    }
}
