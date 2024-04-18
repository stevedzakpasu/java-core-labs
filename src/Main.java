import week1.*;
import week2.DesignPatterns;
import week2.DesignPatterns.Logger;
import week2.DesignPatterns.ShapeFactory;
import week2.DesignPatterns.WindowsUIComponentFactory;
import week2.DesignPatterns.MacOSUIComponentFactory;
import week2.DesignPatterns.LegacyPaymentLibrary;
import week2.DesignPatterns.PaymentAdapter;
import week2.DesignPatterns.OrderProcessingFacade;
import week2.DesignPatterns.Sorter;
import week2.DesignPatterns.BubbleSort;
import java.io.IOException;
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

        ExceptionHandlingExercises exercises = new ExceptionHandlingExercises();

        try {
            exercises.throwCheckedException();
        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            exercises.throwUncheckedException();
        } catch (ArithmeticException e) {
            e.printStackTrace();
        }

        exercises.nestedTryCatch();

        exercises.readFile();


        try {
            exercises.testCustomException();
        } catch (ExceptionHandlingExercises.CustomException e) {
            e.printStackTrace();
        }

        ConcurrencyExercises.imageProcessingWithThreadPool();

        ConcurrencyExercises.threadSafeCache();

        ConcurrencyExercises.sharedCounterWithSynchronization();

        ConcurrencyExercises.deadlockExample();


   DesignPatterns.Logger logger = DesignPatterns.Logger.getInstance();
        logger.log("Singleton Logger created.");


        DesignPatterns.ShapeFactory shapeFactory = new DesignPatterns.ShapeFactory();
        DesignPatterns.Shape circle = shapeFactory.createShape("circle");
        circle.draw();
        DesignPatterns.Shape square = shapeFactory.createShape("square");
        square.draw();



        DesignPatterns.WindowsUIComponentFactory windowsFactory = new DesignPatterns.WindowsUIComponentFactory();
        DesignPatterns.Button windowsButton = windowsFactory.createButton();
        windowsButton.render();
        DesignPatterns.MacOSUIComponentFactory macosFactory = new DesignPatterns.MacOSUIComponentFactory();
        DesignPatterns.Button macosButton = macosFactory.createButton();
        macosButton.render();


        DesignPatterns.LegacyPaymentLibrary legacyPaymentLibrary = new DesignPatterns.LegacyPaymentLibrary();
        DesignPatterns.PaymentAdapter paymentAdapter = new DesignPatterns.PaymentAdapter(legacyPaymentLibrary);
        paymentAdapter.processPayment(100.50f);


        DesignPatterns.OrderProcessingFacade orderProcessingFacade = new DesignPatterns.OrderProcessingFacade();
        orderProcessingFacade.placeOrder("Laptop", 1, 1500.00f, "123 Street");


        DesignPatterns.Sorter sorter = new DesignPatterns.Sorter(new DesignPatterns.BubbleSort());
        int[] array = {3, 1, 4, 1, 5, 9, 2, 6};
}}





