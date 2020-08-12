package ru.job4j.collection;

import java.util.Comparator;

public class LexSort implements Comparator<String> {

    @Override
    public int compare(String left, String right) {
        int rsl = 0;
        String[] l = left.split("\\.");
        String[] r = right.split("\\.");
        int length = Math.min(l.length, r.length);
        for (int i = 0; i < length; i++) {
            if (Integer.parseInt(l[i]) < Integer.parseInt(r[i])) {
                rsl = -1;
                break;
            } else if (Integer.parseInt(l[i]) > Integer.parseInt(r[i])) {
                rsl = 1;
                break;
            }
        }
        if (rsl == 0) {
            rsl = Integer.compare(l.length, r.length);
        }
        return rsl;
    }
}