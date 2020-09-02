package ru.job4j.lambda;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

public class RangeCalculation {
    public static List<Double> diapason(int start, int end,
                                        java.util.function.Function<Double,
                                                Double> func) {
        List<Double> rsl = new ArrayList<>();
        for (; start <= end; start++) {
            rsl.add(
                    func.apply((double) start)
            );
        }
        return rsl;
    }
}
