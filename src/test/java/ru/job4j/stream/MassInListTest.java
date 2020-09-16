package ru.job4j.stream;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.junit.Assert.*;

public class MassInListTest {
    @Test
    public void when1_9() {
        MassInList massinlist = new MassInList();
        Integer[][] mass = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        };
        List<Integer> matrix = massinlist.mInList(mass);
        List<Integer> expected = new ArrayList<>();
        for (int  i = 1; i <= 9; i++) {
            expected.add(i);
        }
        assertEquals(matrix, expected);
    }

    @Test
    public void when1_4() {
        MassInList massinlist = new MassInList();
        Integer[][] mass = {
                {1, 2},
                {3, 4}
        };
        List<Integer> matrix = massinlist.mInList(mass);
        List<Integer> expected = new ArrayList<>();
        for (int  i = 1; i <= 4; i++) {
            expected.add(i);
        }
        assertEquals(matrix, expected);
    }

    @Test
    public void when1_16() {
        MassInList massinlist = new MassInList();
        Integer[][] mass = {
                {1, 2, 3, 4},
                {5, 6, 7, 8},
                {9, 10, 11, 12},
                {13, 14, 15, 16}
        };
        List<Integer> matrix = massinlist.mInList(mass);
        List<Integer> expected = new ArrayList<>();
        for (int  i = 1; i <= 16; i++) {
            expected.add(i);
        }
        assertEquals(matrix, expected);
    }
}