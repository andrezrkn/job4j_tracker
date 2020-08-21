package ru.job4j.collection;

import java.util.Comparator;

public class DepDescComp implements Comparator<String> {
    @Override
    public int compare(String o1, String o2) {
        int rsl;
        if ((o1.contains("K1") && o2.contains("K1"))
                        || (o1.contains("K2") && o2.contains("K2"))) {
            rsl = o1.compareTo(o2);
        } else {
            o1 = o1.substring(2);
            o2 = o2.substring(2);
            rsl = o2.compareTo(o1);
        }
        return rsl;
    }
}