package ru.job4j.oop;

import static org.hamcrest.Matchers.closeTo;
import static org.junit.Assert.assertThat;

import org.junit.Test;

import static org.junit.Assert.*;

public class PointTest {

    @Test
    public void distance3d() {
        Point a = new Point(0, 0, 0);
        Point b = new Point(5, 5, 5);
        double rsl = b.distance3d(a);
        assertThat(rsl, closeTo(8.66, 0.001));
    }
}