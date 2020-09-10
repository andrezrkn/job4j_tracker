package ru.job4j.stream;

import org.junit.Test;
import java.util.List;
import java.util.function.Predicate;
import static org.junit.Assert.*;

 public class SchoolTest {

    @Test
    public void whenAClass() {
        School school = new School();
        Predicate<Student> predicate = Student -> Student.getScore() >= 70
                && Student.getScore() <= 100;
        List<Student> mass = List.of(
                new Student("1", 40),
                new Student("2", 60),
                new Student("3", 80)
                );
        List<Student> expected = List.of(
                new Student("3", 80)
        );
        assertEquals(school.collect(mass, predicate), expected);

    }

    @Test
    public void whenBClass() {
        School school = new School();
        Predicate<Student> predicate = Student -> Student.getScore() >= 50
                && Student.getScore() < 70;
        List<Student> mass = List.of(
                new Student("1", 40),
                new Student("2", 60),
                new Student("3", 80)
        );
        List<Student> expected = List.of(
                new Student("2", 60)
        );
        assertEquals(school.collect(mass, predicate), expected);
    }

    @Test
    public void whenCClass() {
        School school = new School();
        Predicate<Student> predicate = Student -> Student.getScore() > 0
                && Student.getScore() < 50;
        List<Student> mass = List.of(
                new Student("1", 40),
                new Student("2", 60),
                new Student("3", 80)
        );
        List<Student> expected = List.of(
                new Student("1", 40)
        );
        assertEquals(school.collect(mass, predicate), expected);
    }
}