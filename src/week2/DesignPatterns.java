package week2;

import java.util.ArrayList;
import java.util.List;

public class DesignPatterns {

    public static class Logger {
        private static Logger instance;

        private Logger() {}

        public static synchronized Logger getInstance() {
            if (instance == null) {
                instance = new Logger();
            }
            return instance;
        }

        public void log(String message) {
            System.out.println(message);
        }
    }


    public interface Shape {
        void draw();
    }

    public static class Circle implements Shape {
        @Override
        public void draw() {
            System.out.println("Drawing Circle");
        }
    }

    public static class Square implements Shape {
        @Override
        public void draw() {
            System.out.println("Drawing Square");
        }
    }

    public static class ShapeFactory {
        public Shape createShape(String type) {
            if (type.equalsIgnoreCase("circle")) {
                return new Circle();
            } else if (type.equalsIgnoreCase("square")) {
                return new Square();
            } else {
                return null;
            }
        }
    }


    public interface Button {
        void render();
    }

    public static class WindowsButton implements Button {
        @Override
        public void render() {
            System.out.println("Rendering Windows Button");
        }
    }

    public static class MacOSButton implements Button {
        @Override
        public void render() {
            System.out.println("Rendering MacOS Button");
        }
    }

    public interface UIComponentFactory {
        Button createButton();
    }

    public static class WindowsUIComponentFactory implements UIComponentFactory {
        @Override
        public Button createButton() {
            return new WindowsButton();
        }
    }

    public static class MacOSUIComponentFactory implements UIComponentFactory {
        @Override
        public Button createButton() {
            return new MacOSButton();
        }
    }


    public static class LegacyPaymentLibrary {
        public void processPayment(int amount) {
            System.out.println("Processing payment with amount: " + amount);
        }
    }

    public static class PaymentAdapter {
        private LegacyPaymentLibrary legacyPaymentLibrary;

        public PaymentAdapter(LegacyPaymentLibrary legacyPaymentLibrary) {
            this.legacyPaymentLibrary = legacyPaymentLibrary;
        }

        public void processPayment(float amount) {
            int intAmount = (int) amount;
            legacyPaymentLibrary.processPayment(intAmount);
        }
    }


    public static class InventorySystem {
        public void updateInventory(String item, int quantity) {
            System.out.println("Updating inventory for " + item + " with quantity " + quantity);
        }
    }

    public static class PaymentSystem {
        public void processPayment(float amount) {
            System.out.println("Processing payment for amount: " + amount);
        }
    }

    public static class ShippingSystem {
        public void shipOrder(String address) {
            System.out.println("Shipping order to " + address);
        }
    }

    public static class OrderProcessingFacade {
        private InventorySystem inventorySystem;
        private PaymentSystem paymentSystem;
        private ShippingSystem shippingSystem;

        public OrderProcessingFacade() {
            inventorySystem = new InventorySystem();
            paymentSystem = new PaymentSystem();
            shippingSystem = new ShippingSystem();
        }

        public void placeOrder(String item, int quantity, float amount, String address) {
            inventorySystem.updateInventory(item, quantity);
            paymentSystem.processPayment(amount);
            shippingSystem.shipOrder(address);
            System.out.println("Order placed successfully!");
        }
    }


    public interface SortingStrategy {
        void sort(int[] array);
    }

    public static class BubbleSort implements SortingStrategy {
        @Override
        public void sort(int[] array) {
            System.out.println("Sorting array using Bubble Sort");
        }
    }

    public class QuickSort implements SortingStrategy {
        @Override
        public void sort(int[] array) {
            System.out.println("Sorting array using Quick Sort");
        }
    }

    public static class Sorter {
        private SortingStrategy strategy;

        public Sorter(SortingStrategy strategy) {
            this.strategy = strategy;
        }

        public void setStrategy(SortingStrategy strategy) {
            this.strategy = strategy;
        }

        public void performSort(int[] array) {
            strategy.sort(array);
        }
    }


    public interface Subject {
        void registerObserver(Observer observer);
        void removeObserver(Observer observer);
        void notifyObservers();
    }

    public interface Observer {
        void update(int temperature);
    }

    public class WeatherStation implements Subject {
        private List<Observer> observers;
        private int temperature;

        public WeatherStation() {
            observers = new ArrayList<>();
        }

        public void setTemperature(int temperature) {
            this.temperature = temperature;
            notifyObservers();
        }

        @Override
        public void registerObserver(Observer observer) {
            observers.add(observer);
        }

        @Override
        public void removeObserver(Observer observer) {
            observers.remove(observer);
        }

        @Override
        public void notifyObservers() {
            for (Observer observer : observers) {
                observer.update(temperature);
            }
        }
    }

    public class Display implements Observer {
        @Override
        public void update(int temperature) {
            System.out.println("Temperature updated: " + temperature);
        }
    }

    public abstract class DataEncryptionTemplate {
        public void encryptData(String data) {
            String key = generateKey();
            String encryptedData = encrypt(data, key);
            System.out.println("Encrypted Data: " + encryptedData);
        }

        abstract String generateKey();

        abstract String encrypt(String data, String key);
    }

    public class AESEncryption extends DataEncryptionTemplate {
        @Override
        String generateKey() {
            return "AES Key";
        }

        @Override
        String encrypt(String data, String key) {
            return "AES Encrypted Data";
        }
    }

    public class DESEncryption extends DataEncryptionTemplate {
        @Override
        String generateKey() {
            return "DES Key";
        }

        @Override
        String encrypt(String data, String key) {
            return "DES Encrypted Data";
        }
    }

}
