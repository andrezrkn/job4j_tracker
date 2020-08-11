package ru.job4j.collection;

import java.util.Comparator;

public class StringCompare implements Comparator<String> {
    @Override
    public int compare(String left, String right) {
        int lengthLeft, lengthRight, length, rsl = 0;
        lengthLeft = left.length();
        lengthRight = right.length();
        length = lengthLeft <= lengthRight ? lengthLeft : lengthRight;
        for (int i = 0; i < length; i++) {
            if (Character.compare(left.charAt(i), right.charAt(i)) == 0) {
                continue;
            } else if (Character.compare(left.charAt(i), right.charAt(i)) < 0) {
                return -1;
            } else {
                return 1;
            }
        }
        if (rsl == 0) {
            if (lengthLeft < lengthRight) {
                rsl =  -1;
            }
            if (lengthLeft > lengthRight) {
                rsl = 1;
            }
        }
        return rsl;
    }
}
