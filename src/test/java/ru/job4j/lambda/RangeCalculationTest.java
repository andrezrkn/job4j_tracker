package ru.job4j.lambda;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

public class RangeCalculationTest {
    @Test
    public void whenLinearFunctionThenLinearResults() {
        List<Double> result = RangeCalculation.diapason(5, 8, x -> (2 * x + 1));
        List<Double> expected = Arrays.asList(11D, 13D, 15D, 17D);
        assertThat(result, is(expected));
    }

    @Test
    public void whenExponentialFunction() {
        List<Double> result = RangeCalculation.diapason(1, 4, x -> (
                Math.pow(5, x)
        ));
        List<Double> expected = Arrays.asList(5D, 25D, 125D, 625D);
        assertThat(result, is(expected));
    }

    @Test
    public void whenQuadraticFunction() {
        List<Double> result = RangeCalculation.diapason(2, 5, x ->
                (2 * x * x + 5 * x + 1));
        List<Double> expected = Arrays.asList(19D, 34D, 53D, 76D);
        assertThat(result, is(expected));
    }
}