import week1.*;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        DesignPattern.CarFactory factory = new DesignPattern.SUVFactory();
        DesignPattern.Car car = factory.createCar();
        car.drive();

        DataEncapsulation outer = new DataEncapsulation(10);
        DataEncapsulation.Inner inner = outer.new Inner();
        System.out.println("Initial data: " + inner.getData());
        inner.setData(20);
        System.out.println("Updated data: " + inner.getData());


        int intValue = 15;
        int thresholdInt = 10;
        boolean intValidationResult = DataValidator.validateData(intValue, thresholdInt);
        System.out.println("Integer validation result: " + intValidationResult);

        double doubleValue = 7.5;
        double thresholdDouble = 5.0;
        boolean doubleValidationResult = DataValidator.validateData(doubleValue, thresholdDouble);
        System.out.println("Double validation result: " + doubleValidationResult);

        Stack<Integer> intStack = new Stack<>();
        intStack.push(10);
        intStack.push(20);
        intStack.push(30);

        while (!intStack.isEmpty()) {
            System.out.println(intStack.pop());
        }

        Stack<String> stringStack = new Stack<>();
        stringStack.push("Hello");
        stringStack.push("World");

        while (!stringStack.isEmpty()) {
            System.out.println(stringStack.pop());
        }


        ThreadSafeCache<String, Integer> cache = new ThreadSafeCache<>();

            cache.put("key1", 10);
            cache.put("key2", 20);

            System.out.println("Value for key1: " + cache.get("key1"));
            System.out.println("Value for key2: " + cache.get("key2"));


            cache.remove("key1");


            System.out.println("Contains key1: " + cache.containsKey("key1"));
        List<Person> people = new ArrayList<>();
            people.add(new Person("Alice", 30, 50000));
            people.add(new Person("Bob", 25, 60000));
            people.add(new Person("Charlie", 35, 45000));


            people.sort(Comparator.comparingDouble(Person::getSalary));

            people.stream()
                    .filter(person -> person.getAge() > 25)
                .map(Person::getName)
                    .forEach(System.out::println);
}}





