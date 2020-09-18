package ru.job4j.lambda;

import java.util.ArrayList;
import java.util.List;
import java.util.function.BiFunction;

public class SearchAtt {
    public static List<Attachment> filter(String c1,
                                          BiFunction<String, String,
                                                  Boolean> func,
                                          List<Attachment> list,
                                          boolean flag) {
        //flag = true - filterName, false - filterSize
        List<Attachment> rsl = new ArrayList<>();
        for (Attachment element : list) {
            if (flag) {
                if (func.apply(c1, element.getName())) {
                    rsl.add(element);
                }
            } else {
                if (func.apply(c1, element.getName())) {
                    rsl.add(element);
                }
            }
        }
        return rsl;
    }

    public static List<Attachment> filterSize(List<Attachment> list) {
        BiFunction<String, String, Boolean> func = new BiFunction<String,
                String, Boolean>() {
            @Override
            public Boolean apply(String s, String s2) {
                int integerS = Integer.parseInt(s);
                int integerS2 = Integer.parseInt(s2);
                return integerS2 > integerS;
            }
        };
        return filter("100", func, list, false);
    }

    public static List<Attachment> filterName(List<Attachment> list) {
        BiFunction<String, String, Boolean> func = new BiFunction<String,
                String, Boolean>() {
            @Override
            public Boolean apply(String s, String s2) {
                return s.contains(s2);
            }
        };
        return filter("bug", func, list, true);
    }
}