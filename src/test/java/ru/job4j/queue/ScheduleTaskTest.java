package ru.job4j.queue;

import org.junit.Test;

import java.util.Comparator;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class ScheduleTaskTest {
    @Test
    public void whenTwoDirectorTaskThenReadMethodTest() {
        Comparator<Task> comparator = new TaskByPositionAsc()
                .thenComparing(new TaskByUrgencyDesc());
        ScheduleTask scheduleTask = new ScheduleTask(comparator);
        scheduleTask.addTask(new Task(Position.DEPARMENT_HEAD, "description_1", 10));
        scheduleTask.addTask(new Task(Position.DIRECTOR, "description_2", 4));
        scheduleTask.addTask(new Task(Position.DIRECTOR, "description_3", 8));
        String expected = "description_3";
        String result = scheduleTask.readTask().description();
        assertThat(result, is(expected));
    }

    @Test
    public void whenTwoDepartmentHeadTaskAndEqualUrgencyThenGetMethodTest() {
        Comparator<Task> comparator = new TaskByPositionAsc()
                .thenComparing(new TaskByUrgencyDesc());
        ScheduleTask scheduleTask = new ScheduleTask(comparator);
        scheduleTask.addTask(new Task(Position.DEPARMENT_HEAD, "description_1", 7));
        scheduleTask.addTask(new Task(Position.MANAGER, "description_2", 10));
        scheduleTask.addTask(new Task(Position.DEPARMENT_HEAD, "description_3", 7));
        String expected = "description_1";
        String result = scheduleTask.getTask().description();
        assertThat(result, is(expected));
        scheduleTask.getTask();
        expected = "description_2";
        result = scheduleTask.getTask().description();
        assertThat(result, is(expected));
    }
}