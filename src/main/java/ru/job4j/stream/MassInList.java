package ru.job4j.stream;

import ru.job4j.tracker.StubOutput;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class MassInList {
    public static void main(String[] args) {
        Integer[][] mass = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        };
         List<Integer> matrix =  Stream.of(mass)
                        .flatMap(
                                Stream::of
                        ).collect(
                                Collectors.toList()
                );
        System.out.println(matrix.toString());
    }
}
