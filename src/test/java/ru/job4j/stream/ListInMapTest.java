package ru.job4j.stream;

import org.junit.Test;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicReference;
import java.util.stream.Collectors;
import static org.junit.Assert.*;
import static org.hamcrest.Matchers.is;

public class ListInMapTest {
    @Test
    public void whenNoSame() {
        AtomicReference<Integer> id = new AtomicReference<>(0);
        List<Student> mass = List.of(
                new Student("1", 98),
                new Student("1", 99),
                new Student("3", 100)
        );
        Map st = mass.stream()
                .collect(
                        Collectors.toMap(
                                Student::getSurname,
                                Student -> Student,
                                (a, b) -> {
                                   id.set(id.get() + 1);
                                   a.setSurname(a.getSurname() + id.toString());
                                   return a;
                                }
                        )
                );
        Student m1 = new Student("1", 98);
        Student m2 = new Student("11", 99);
        Student m3 = new Student("3", 100);
        Map expected = new HashMap();
        expected.put(m1.getSurname(), m1);
        expected.put(m2.getSurname(), m2);
        expected.put(m3.getSurname(), m3);
        assertThat(st, is(expected));
    }
}