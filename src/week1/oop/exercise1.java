package week1.oop;

public class exercise1 {

    // Defines a Sedan type of Car
    public static class Sedan implements Car {
        @Override
        public void drive() {
            System.out.println("Driving Sedan");
        }
    }

    // Defines an SUV type of Car
    public static class SUV implements Car {
        @Override
        public void drive() {
            System.out.println("Driving SUV");
        }
    }

    // Defines a Truck type of Car
    public static class Truck implements Car {
        @Override
        public void drive() {
            System.out.println("Driving Truck");
        }
    }

    // Factory interface for creating instances of Car
    public interface CarFactory {
        Car createCar();
    }

    // Factory for creating Sedan cars
    public static class SedanFactory implements CarFactory {
        @Override
        public Car createCar() {
            return new Sedan();
        }
    }

    // Factory for creating SUV cars
    public static class SUVFactory implements CarFactory {
        @Override
        public Car createCar() {
            return new SUV();
        }
    }

    // Factory for creating Truck cars
    public static class TruckFactory implements CarFactory {
        @Override
        public Car createCar() {
            return new Truck();
        }
    }

    public static void main(String[] args) {
        // Creating and driving a Sedan
        CarFactory sedanFactory = new SedanFactory();
        Car sedan = sedanFactory.createCar();
        sedan.drive();

        // Creating and driving an SUV
        CarFactory suvFactory = new SUVFactory();
        Car suv = suvFactory.createCar();
        suv.drive();

        // Creating and driving a Truck
        CarFactory truckFactory = new TruckFactory();
        Car truck = truckFactory.createCar();
        truck.drive();
    }
}