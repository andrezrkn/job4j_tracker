package ru.job4j.poly;

public interface Transport {
    void ride();

    void passengers(int quantity);

    double fillUp(double fuelVolume);
}

