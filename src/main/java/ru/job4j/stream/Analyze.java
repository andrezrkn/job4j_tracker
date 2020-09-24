package ru.job4j.stream;

import java.util.*;
import java.util.stream.Stream;
import java.util.stream.Collectors;

public class Analyze {

    public static double averageScore(Stream<Pupil> stream) {
        return stream
                .flatMap(p -> p.getSubjects().stream())
                .mapToInt(Subject::getScore)
                .average()
                .orElse(0D);
    }

    public static List<Tuple> averageScoreBySubject(Stream<Pupil> stream) {
        return stream
                .map(e -> new Tuple(e.getName(), e.getSubjects()
                                .stream()
                                .mapToInt(Subject::getScore)
                                .average().orElse(0D)
                        )
                ).collect(Collectors.toList());
    }

    public static List<Tuple> averageScoreByPupil(Stream<Pupil> stream) {
        return stream
                .flatMap(p -> p.getSubjects().stream())
                .collect(
                        Collectors.groupingBy(
                                Subject::getName,
                                LinkedHashMap::new,
                                Collectors.averagingDouble(Subject::getScore)
                        )
                ).entrySet()
                .stream()
                .map(e -> new Tuple(e.getKey(), e.getValue()))
                .collect(Collectors.toList());
    }

    public static Tuple bestStudent(Stream<Pupil> stream) {
        return stream.map(
                e -> new Tuple(e.getName(), e.getSubjects()
                            .stream()
                            .mapToInt(Subject::getScore)
                        .sum()
                )
    }

    public static Tuple bestSubject(Stream<Pupil> stream) {
        return stream
                .flatMap(p -> p.getSubjects().stream())
                .collect(
                        Collectors.groupingBy(
                                Subject::getName,
                                LinkedHashMap::new,
                                Collectors.summingInt(Subject::getScore)
                        )
                ).entrySet()
                .stream()
    }
}