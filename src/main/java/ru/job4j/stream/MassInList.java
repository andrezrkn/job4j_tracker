package ru.job4j.stream;

import ru.job4j.tracker.StubOutput;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class MassInList {
    public List<Integer> mInList(Integer[][] mass) {
        return Stream.of(mass)
                .flatMap(
                        Stream::of
                ).collect(
                        Collectors.toList()
                );
    }
}
