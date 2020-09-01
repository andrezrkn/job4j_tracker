package ru.job4j.lambda;

import java.util.Arrays;
import java.util.Comparator;

public class FI {
    public static void main(String[] args) {
        Attachment[] atts = {
                new Attachment("image 1", 20),
                new Attachment("image 3", 120),
                new Attachment("image 2", 23)
        };
        Comparator<String> cmpDescSize = (left, right) -> {
            int rsl = 0;
            System.out.print("Compare length: " + left + "and" + right + ": ");
            if (left.length() - right.length() > 0) {
                rsl = 1;
                System.out.println("left > right");
            } else if (left.length() - right.length() < 0) {
                rsl = -1;
                System.out.println("left < right");
            } else if (left.length() - right.length() > 0) {
                rsl = 0;
                System.out.println("left = right");
            }
            return rsl;
        };
    }

}