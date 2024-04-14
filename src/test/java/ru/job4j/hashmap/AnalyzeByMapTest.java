package ru.job4j.hashmap;

import org.hamcrest.Matchers;
import org.junit.Test;
import java.util.List;
import static org.junit.Assert.*;
import static org.hamcrest.Matchers.*;
public class AnalyzeByMapTest {
    @Test
    public void whenAverageScore() {
        double average = AnalyzeByMap.averageScore(
                List.of(
                        new Pupil("Ivanov",
                                List.of(
                                        new Subject("Math", 100),
                                        new Subject("Lang", 70),
                                        new Subject("Philosophy", 80)
                                )
                        ),
                        new Pupil("Petrov",
                                List.of(
                                        new Subject("Math", 80),
                                        new Subject("Lang", 90),
                                        new Subject("Philosophy", 70)
                                )
                        ),
                        new Pupil("Sidorov",
                                List.of(
                                        new Subject("Math", 70),
                                        new Subject("Lang", 60),
                                        new Subject("Philosophy", 50)
                                )
                        )
                )
        );
        assertThat(average, closeTo(74.44, 0.01D));
    }

    @Test
    public void whenListOfPupilAverage() {
        List<Label> average = AnalyzeByMap.averageScoreByPupil(
                List.of(
                        new Pupil("Ivanov",
                                List.of(
                                        new Subject("Math", 100),
                                        new Subject("Lang", 60),
                                        new Subject("Philosophy", 80)
                                )
                        ),
                        new Pupil("Petrov",
                                List.of(
                                        new Subject("Math", 80),
                                        new Subject("Lang", 90),
                                        new Subject("Philosophy", 70)
                                )
                        ),
                        new Pupil("Sidorov",
                                List.of(
                                        new Subject("Math", 70),
                                        new Subject("Lang", 60),
                                        new Subject("Philosophy", 50)
                                )
                        )
                )
        );
        assertThat(average, Matchers.containsInAnyOrder(List.of(
                new Label("Petrov", 80D),
                new Label("Ivanov", 80D),
                new Label("Sidorov", 60D)
        ).toArray()));
    }

    @Test
    public void whenListOfSubjectAverage() {
        List<Label> average = AnalyzeByMap.averageScoreBySubject(
                List.of(
                        new Pupil("Ivanov",
                                List.of(
                                        new Subject("Math", 70),
                                        new Subject("Lang", 90),
                                        new Subject("Philosophy", 100)
                                )
                        ),
                        new Pupil("Petrov",
                                List.of(
                                        new Subject("Lang", 60),
                                        new Subject("Math", 60),
                                        new Subject("Philosophy", 60)
                                )
                        ),
                        new Pupil("Sidorov",
                                List.of(
                                        new Subject("Philosophy", 50),
                                        new Subject("Lang", 60),
                                        new Subject("Math", 80)
                                )
                        )
                )
        );
        assertThat(average, Matchers.containsInAnyOrder(List.of(
                new Label("Math", 70D),
                new Label("Lang", 70D),
                new Label("Philosophy", 70D)
        ).toArray()));
    }

    @Test
    public void whenBestPupil() {
        Label best = AnalyzeByMap.bestStudent(
                List.of(
                        new Pupil("Ivanov",
                                List.of(
                                        new Subject("Math", 100),
                                        new Subject("Lang", 60),
                                        new Subject("Philosophy", 80)
                                )
                        ),
                        new Pupil("Petrov",
                                List.of(
                                        new Subject("Math", 80),
                                        new Subject("Lang", 80),
                                        new Subject("Philosophy", 70)
                                )
                        ),
                        new Pupil("Sidorov",
                                List.of(
                                        new Subject("Math", 70),
                                        new Subject("Lang", 60),
                                        new Subject("Philosophy", 50)
                                )
                        )
                )
        );
        assertEquals(best, new Label("Ivanov", 240D));
    }

    @Test
    public void whenBestSubject() {
        Label best = AnalyzeByMap.bestSubject(
                List.of(
                        new Pupil("Ivanov",
                                List.of(
                                        new Subject("Math", 100),
                                        new Subject("Lang", 60),
                                        new Subject("Philosophy", 80)
                                )
                        ),
                        new Pupil("Petrov",
                                List.of(
                                        new Subject("Lang", 90),
                                        new Subject("Math", 80),
                                        new Subject("Philosophy", 70)
                                )
                        ),
                        new Pupil("Sidorov",
                                List.of(
                                        new Subject("Philosophy", 50),
                                        new Subject("Math", 70),
                                        new Subject("Lang", 60)
                                )
                        )
                )
        );
        assertEquals(best, new Label("Math", 250D));
    }
}