package ru.job4j.stream;

import java.util.List;
import java.util.stream.Collectors;

public class ListInMap {
    public static void main(String[] args) {
        List<Student> mass = List.of(
                new Student("1", 98),
                new Student("1", 99),
                new Student("3", 100)
        );
        mass.stream()
                .collect(
                        Collectors.toMap(
                                Student::getSurname,
                                Student -> Student,
                                (a, b) -> {
                                    int id = 0;
                                    a.setSurname(a.getSurname() + ++id);
                                    return a;
                                }
                        )
                );
    }
}
