package ru.job4j.stream;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.junit.Assert.*;

public class MassInListTest {
    @Test
    public void when123456789() {
        Integer[][] mass = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        };
        List<Integer> matrix = Stream.of(mass)
                .flatMap(
                        Stream::of
                ).collect(
                        Collectors.toList()
                );
        List<Integer> expected = new ArrayList<>();
        for (int  i = 1; i <= 9; i++) {
            expected.add(i);
        }
        assertEquals(matrix, expected);
    }
}