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
                                (a, b) -> a
                        )
                );
        Student m1 = new Student("1", 98);
        Student m3 = new Student("3", 100);
        Map expected = new HashMap();
        expected.put(m1.getSurname(), m1);
        expected.put(m3.getSurname(), m3);
        assertThat(st, is(expected));
    }
}