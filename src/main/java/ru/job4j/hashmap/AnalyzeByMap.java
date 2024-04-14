package ru.job4j.hashmap;

import java.util.*;

public class AnalyzeByMap {
    public static double averageScore(List<Pupil> pupils) {
        double average = 0;
        double count = 0;
        for (Pupil p : pupils) {
            for (Subject s : p.subjects()) {
                average += s.score();
                count++;
            }
        }
        return average / count;
    }

    public static List<Label> averageScoreByPupil(List<Pupil> pupils) {
        List<Label> students = new ArrayList<>();
        for (Pupil p : pupils) {
            double average = 0, count = 0;
            for (Subject s : p.subjects()) {
                average += s.score();
                count++;
            }
            students.add(new Label(p.name(), average / count));
        }
        return students;
    }

    public static List<Label> averageScoreBySubject(List<Pupil> pupils) {
        Map<String, Double> subjectsAv = new LinkedHashMap<>();
        List<Label> result = new ArrayList<>();
        for (Pupil p : pupils) {
            for (Subject s : p.subjects()) {
                if (subjectsAv.containsKey(s.name())) {
                    subjectsAv.put(s.name(), subjectsAv.get(s.name()) + s.score());
                } else {
                    subjectsAv.put(s.name(), (double) s.score());
                }
            }
        }
        for (String key : subjectsAv.keySet()) {
            result.add(new Label(key, subjectsAv.get(key) / pupils.size()));
        }
        return result;
    }

    public static Label bestStudent(List<Pupil> pupils) {
        Label best = new Label("", 0);
        for (Pupil p : pupils) {
            double sum = 0;
            for (Subject s : p.subjects()) {
                sum += s.score();
            }
            if (best.score() < sum) {
                best = new Label(p.name(), sum);
            }
        }
        return best;
    }

    public static Label bestSubject(List<Pupil> pupils) {
        Map<String, Double> subjectsAv = new LinkedHashMap<>();
        Label best = new Label("", 0D);
        for (Pupil p : pupils) {
            for (Subject s : p.subjects()) {
                if (subjectsAv.containsKey(s.name())) {
                    subjectsAv.put(s.name(), subjectsAv.get(s.name()) + s.score());
                } else {
                    subjectsAv.put(s.name(), (double) s.score());
                }
            }
        }
        for (String key : subjectsAv.keySet()) {
            if (best.score() < subjectsAv.get(key)) {
                best = new Label(key, subjectsAv.get(key));
            }
        }
        return best;
    }
}
