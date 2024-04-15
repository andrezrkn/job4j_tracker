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
                subjectsAv.put(s.name(), subjectsAv.getOrDefault(s.name(), 0D) + s.score());
            }
        }
        for (String key : subjectsAv.keySet()) {
            result.add(new Label(key, subjectsAv.get(key) / pupils.size()));
        }
        return result;
    }

    public static Label bestStudent(List<Pupil> pupils) {
        Label best = null;
        for (Pupil p : pupils) {
            double sum = 0;
            for (Subject s : p.subjects()) {
                sum += s.score();
            }
            if (best == null || best.score() < sum) {
                best = new Label(p.name(), sum);
            }
        }
        return best;
    }

    public static Label bestSubject(List<Pupil> pupils) {
        Map<String, Double> subjectsAv = new LinkedHashMap<>();
        Label best = null;
        for (Pupil p : pupils) {
            for (Subject s : p.subjects()) {
                subjectsAv.put(s.name(), subjectsAv.getOrDefault(s.name(), 0D) + s.score());
            }
        }
        for (String key : subjectsAv.keySet()) {
            if (best == null || best.score() < subjectsAv.get(key)) {
                best = new Label(key, subjectsAv.get(key));
            }
        }
        return best;
    }
}
