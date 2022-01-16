package ru.job4j.stream;

public class Car {
    private String brand; //марка
    private String body; //тип кузов
    private String driveUnit; //тип привода
    private String engine; //тип двигателя
    private String enginePosition; //расположение двигателя отноительно кузова
    private int maxSpeed; //максимальная скорость
    private int numOfDoors; //количество дверей

    static class Builder {
        private String brand; //марка
        private String body; //тип кузов
        private String driveUnit; //тип привода
        private String engine; //тип двигателя
        private String enginePosition; //расположение двигателя
        // отноительно кузова
        private int maxSpeed; //максимальная скорость
        private int numOfDoors; //количество дверей

        Builder buildBrand(String brand) {
            this.brand = brand;
            return this;
        }

        Builder buildBody(String body) {
            this.body = body;
            return this;
        }

        Builder buildDriveUnit(String driveUnit) {
            this.driveUnit = driveUnit;
            return this;
        }

        Builder buildEngine(String engine) {
            this.engine = engine;
            return this;
        }

        Builder buildEnginePosition(String enginePosition) {
            this.enginePosition = enginePosition;
            return this;
        }

        Builder buildMaxSpeed(int maxSpeed) {
            this.maxSpeed = maxSpeed;
            return this;
        }

        Builder buildNumOfDoors(int numOfDoors) {
            this.numOfDoors = numOfDoors;
            return this;
        }

        Car build() {
            Car car = new Car();
            car.maxSpeed = maxSpeed;
            car.driveUnit = driveUnit;
            car.enginePosition = enginePosition;
            car.engine = engine;
            car.body = body;
            car.brand = brand;
            car.numOfDoors = numOfDoors;
            return car;
        }
    }

    @Override
    public String toString() {
        return "Car{"
                + "brand='" + brand + '\''
                + ", body='" + body + '\''
                + ", driveUnit='" + driveUnit + '\''
                + ", engine='" + engine + '\''
                + ", enginePosition='" + enginePosition + '\''
                + ", maxSpeed=" + maxSpeed
                + ", numOfDoors=" + numOfDoors
                + '}';
    }

    public static void main(String[] args) {
        Car car = new Builder().buildBrand("volvo")
                .buildBody("wagon")
                .buildEngine("electric")
                .buildEnginePosition("front")
                .buildDriveUnit("4WD")
                .buildNumOfDoors(5)
                .buildMaxSpeed(250)
                .build();
        System.out.println(car);
    }
}
