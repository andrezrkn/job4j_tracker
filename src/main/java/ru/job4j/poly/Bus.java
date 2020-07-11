package ru.job4j.poly;

public class Bus implements Transport {
    @Override
    public void ride() {
        int km = 0;
        km++;
    }

    @Override
    public void passengers(int quantity) {
        int weight = quantity * 60;
    }

    @Override
    public double fillUp(double fuelVolume) {
        double total = fuelVolume * 50;
        return total;
    }
}
