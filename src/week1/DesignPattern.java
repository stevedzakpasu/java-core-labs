package week1;
//Lab Exercise #1: Implement a Design Pattern
// Implement a design pattern of your choice in a new file named week1.DesignPattern.java.
public class DesignPattern {

    public interface Car {
        void drive();
    }

    public static class Sedan implements Car {
        @Override
        public void drive() {
            System.out.println("Driving Sedan");
        }
    }

    public static class SUV implements Car {
        @Override
        public void drive() {
            System.out.println("Driving SUV");
        }
    }

    public static class Truck implements Car {
        @Override
        public void drive() {
            System.out.println("Driving Truck");
        }
    }

    public interface CarFactory {
        Car createCar();
    }

    public static class SedanFactory implements CarFactory {
        @Override
        public Car createCar() {
            return new Sedan();
        }
    }

    public static class SUVFactory implements CarFactory {
        @Override
        public Car createCar() {
            return new SUV();
        }
    }

    public static class TruckFactory implements CarFactory {
        @Override
        public Car createCar() {
            return new Truck();
        }
    }

}
