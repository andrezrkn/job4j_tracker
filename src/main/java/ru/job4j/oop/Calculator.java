package ru.job4j.oop;

public class Calculator {

    private static int x = 5;

    public static int sum(int y) {
        return x + y;
    }

    public static int minus(int y) {
        return y - x;
    }

    public double divide(int y) {
        return y / (double) x;
    }

    public int multiply(int a) {
        return x * a;
    }

    public double sumAllOperation(int y) {
        return sum(y) + minus(y) + divide(y) + multiply(y);
    }

    public static void main(String[] args) {
        Calculator calculator = new Calculator();
        int rslMultiply = calculator.multiply(5);
        int rslSum = Calculator.sum(10);
        int rslMinus = Calculator.minus(80);
        double rslDivide = calculator.divide(6);
        double rslSAO = calculator.sumAllOperation(1);
        System.out.println("mulitply result : " + rslMultiply);
        System.out.println("summation result: " + rslSum);
        System.out.println("minus result: " + rslMinus);
        System.out.println("divide result: " + rslDivide);
        System.out.println("sum all operations result: " + rslSAO);
    }
}
