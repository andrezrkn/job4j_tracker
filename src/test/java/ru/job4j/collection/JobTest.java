package ru.job4j.collection;

import org.junit.Test;
import java.util.Comparator;

import static org.hamcrest.Matchers.greaterThan;
import static org.hamcrest.Matchers.lessThan;
import static org.junit.Assert.assertThat;

public class JobTest {
    @Test
    public void whenDescendingByNameAndPrority() {
        Comparator<Job> cmpNamePriority = new JobDescendingByName().thenComparing(new JobDescendingByPriority());
        int rsl = cmpNamePriority.compare(
                new Job("Impl task", 0),
                new Job("Fix bug", 1)
        );
        assertThat(rsl, lessThan(0));
    }

    @Test
    public void whenDescendingByNameAndAscendingByPrority() {
        Comparator<Job> cmpNamePriority = new JobDescendingByName().thenComparing(new JobAscendingByPriority());
        int rsl = cmpNamePriority.compare(
                new Job("Impl task", 0),
                new Job("Fix bug", 1)
        );
        assertThat(rsl, lessThan(0));
    }

    @Test
    public void whenDescendingByNameAndAscendingByPrority2() {
        Comparator<Job> cmpNamePriority = new JobDescendingByName().thenComparing(new JobAscendingByPriority());
        int rsl = cmpNamePriority.compare(
                new Job("Fix bug", 0),
                new Job("Fix bug", 1)
        );
        assertThat(rsl, lessThan(0));
    }

    @Test
    public void whenDescendingByName() {
        Comparator<Job> cmpNamePriority = new JobDescendingByName();
        int rsl = cmpNamePriority.compare(
                new Job("Fix bug", 1),
                new Job("Impl task", 0)
        );
        assertThat(rsl, greaterThan(0));
    }

    @Test
    public void whenDescendingByPriority() {
        Comparator<Job> cmpNamePriority = new JobDescendingByPriority();
        int rsl = cmpNamePriority.compare(
                new Job("Fix bug", 1),
                new Job("Impl task", 0)
        );
        assertThat(rsl, lessThan(0));
    }


    @Test
    public void whenAscendingByName() {
        Comparator<Job> cmpNamePriority = new JobAscendingByName();
        int rsl = cmpNamePriority.compare(
                new Job("Fix bug", 1),
                new Job("Impl task", 0)
        );
        assertThat(rsl, lessThan(0));
    }

    @Test
    public void whenAscendingByPriority() {
        Comparator<Job> cmpNamePriority = new JobAscendingByPriority();
        int rsl = cmpNamePriority.compare(
                new Job("Fix bug", 1),
                new Job("Impl task", 0)
        );
        assertThat(rsl, greaterThan(0));
    }
}