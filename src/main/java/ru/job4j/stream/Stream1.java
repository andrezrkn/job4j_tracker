package ru.job4j.stream;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Stream1 {
    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(-2);
        list.add(3);
        list.add(-4);
        list.add(5);
        list.add(-6);
        List<Integer> plus = list.stream().filter(
              o -> o > 0
        ).collect(Collectors.toList());
    }
}
