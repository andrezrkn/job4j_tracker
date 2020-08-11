package ru.job4j.collection;

import java.util.Comparator;

public class LexSort implements Comparator<String> {

    @Override
    public int compare(String left, String right) {
        int rsl = 0;
            if (left.charAt(0) >= 0x30 && left.charAt(0) <= 0x39
                    && right.charAt(0) >= 0x30 && right.charAt(0) <= 0x39) {
                if (Character.compare(left.charAt(0), right.charAt(0)) == 0) {
                    rsl = compare(left.substring(1), right.substring(1));
                } else if (Character.compare(left.charAt(0), right.charAt(0)) < 0) {
                    if (left.length() != 1 && right.length() != 1) {
                        if (left.charAt(1) >= 0x30 && left.charAt(1) <= 0x39
                                && (right.charAt(1) < 0x30 || right.charAt(1) > 0x39)) {
                            return 1;
                        } else if ((left.charAt(1) < 0x30 || left.charAt(1) > 0x39)
                                && right.charAt(1) >= 0x30 && right.charAt(1) <= 0x39) {
                            return -1;
                        }
                    }
                    rsl = -1;
                } else {
                    if (left.length() != 1 && right.length() != 1) {
                        if (left.charAt(1) >= 0x30 && left.charAt(1) <= 0x39
                                && (right.charAt(1) < 0x30 || right.charAt(1) > 0x39)) {
                            return 1;
                        } else if ((left.charAt(1) < 0x30 || left.charAt(1) > 0x39)
                                && right.charAt(1) >= 0x30 && right.charAt(1) <= 0x39) {
                            return -1;
                        }
                    }
                    rsl = 1;
                }
            } else if ((left.charAt(0) < 0x30 || left.charAt(0) > 0x39)
                    && (right.charAt(0) >= 0x30 && right.charAt(0) <= 0x39)) {
                rsl = -1;
            } else if ((left.charAt(0) >= 0x30 && left.charAt(0) <= 0x39)
                    && (right.charAt(0) < 0x30 || right.charAt(0) > 0x39)) {
                rsl = 1;
            }
        return rsl;
    }
}