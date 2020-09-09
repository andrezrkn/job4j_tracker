package ru.job4j.stream;

import org.junit.Test;
import java.util.List;
import static org.junit.Assert.*;

@FunctionalInterface
interface MyPredicate {
    boolean test(Integer value);
}

 public class SchoolTest {

    @Test
    public void whenAClass() {
        MyPredicate myPredicate = x -> x >= 70 && x <= 100;
        List<Student> mass = List.of(
                new Student("1", 40),
                new Student("2", 60),
                new Student("3", 80)
                );
        int count = 0;
        for (Student element : mass) {
           if  (myPredicate.test(element.getScore())) {
               count++;
           }
        }
        assertEquals(1, count);
    }

    @Test
    public void whenBClass() {
        MyPredicate myPredicate = x -> x >= 50 && x < 70;
        List<Student> mass = List.of(
                new Student("1", 40),
                new Student("2", 60),
                new Student("3", 80)
        );
        int count = 0;
        for (Student element : mass) {
            if  (myPredicate.test(element.getScore())) {
                count++;
            }
        }
        assertEquals(1, count);
    }

    @Test
    public void whenCClass() {
        MyPredicate myPredicate = x -> x > 0 && x < 50;
        List<Student> mass = List.of(
                new Student("1", 40),
                new Student("2", 60),
                new Student("3", 80)
        );
        int count = 0;
        for (Student element : mass) {
            if  (myPredicate.test(element.getScore())) {
                count++;
            }
        }
        assertEquals(1, count);
    }
}