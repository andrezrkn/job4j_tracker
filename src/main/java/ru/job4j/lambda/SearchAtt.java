package ru.job4j.lambda;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class SearchAtt {
    public static List<Attachment> filter(Predicate<Attachment> predicate,
                                          List<Attachment> list) {
        List<Attachment> rsl = new ArrayList<>();
        for (Attachment element : list) {
            if (predicate.test(element)) {
                rsl.add(element);
            }
        }
        return rsl;
    }

    public static List<Attachment> filterSize(List<Attachment> list) {
        Predicate<Attachment> predicate = Attachment ->
                Attachment.getSize() > 100;
        return filter(predicate, list);
    }

    public static List<Attachment> filterName(List<Attachment> list) {
        Predicate<Attachment> predicate = Attachment ->
                Attachment.getName().contains("bug");
        return filter(predicate, list);
    }
}