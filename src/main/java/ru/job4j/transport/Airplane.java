package ru.job4j.transport;

public class Airplane implements Vehicle {
    @Override
    public void move() {
        System.out.println("парит по воздуху");
    }
}
