package ru.job4j.stream;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.OptionalDouble;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Stream;
import java.util.stream.Collectors;

public class Analyze {

    public static double averageScore(Stream<Pupil> stream) {
        double average = 0D;
        OptionalDouble av =  stream.mapToInt(
                e -> e.getSubjects()
                        .stream()
                        .mapToInt(
                                Subject::getScore
                        ).sum()
        ).average();
        if (av.isPresent()) {
            average = av.getAsDouble();
        }
        return average;
    }

    public static List<Tuple> averageScoreBySubject(Stream<Pupil> stream) {
         return stream.map(
                e -> {
                    double average = 0D;
                    OptionalDouble av = e.getSubjects()
                            .stream()
                            .mapToInt(
                                    Subject::getScore
                            ).average();
                    if (av.isPresent()) {
                        average = av.getAsDouble();
                    }
                    return new Tuple(e.getName(), average);
                }
        ).collect(Collectors.toList());
    }

    public static List<Tuple> averageScoreByPupil(Stream<Pupil> stream) {
        List<List<Subject>> pSubjects = stream.map(Pupil::getSubjects)
                .collect(Collectors.toList());
        for (List<Subject> element : pSubjects) {
            element.stream()
                    .collect(Collectors.groupingBy(Subject::getName),
                            Collectors.averagingDouble(Subject::getScore)
                    );
        }
    }

    public static Tuple bestStudent(Stream<Pupil> stream) {
        Tuple max = new Tuple("", -1);
        List<Tuple> list = stream.map(
                e -> new Tuple(e.getName(), e.getSubjects()
                            .stream()
                            .mapToInt(
                                    Subject::getScore
                            ).sum()
                )
                ).collect(Collectors.toList());
        for (Tuple element : list) {
            if (element.getScore() > max.getScore()) {
                max = element;
            }
        }
        return max;
    }

    public static Tuple bestSubject(Stream<Pupil> stream) {
        return null;
    }
}