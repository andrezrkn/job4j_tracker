package ru.job4j.collection;

import java.util.Comparator;

public class StringCompare implements Comparator<String> {
    @Override
    public int compare(String left, String right) {
        int lengthLeft, lengthRight, length, rsl = 0;
        lengthLeft = left.length();
        lengthRight = right.length();
        length = Math.min(lengthLeft, lengthRight);
        for (int i = 0; i < length; i++) {
            rsl = Character.compare(left.charAt(i), right.charAt(i));
            if (rsl != 0) {
                break;
            }
        }
        if (rsl == 0) {
            rsl = Integer.compare(lengthLeft, lengthRight);
        }
        return rsl;
    }
}
