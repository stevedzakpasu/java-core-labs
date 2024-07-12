package week1.oop;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class Person {
    private String name;
    private int age;
    private double salary;

    public Person(String name, int age, double salary) {
        this.name = name;
        this.age = age;
        this.salary = salary;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public double getSalary() {
        return salary;
    }

    @Override
    public String toString() {
        return "week1.oop.Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", salary=" + salary +
                '}';
    }

    public class Main {
        public static void main(String[] args) {
            List<Person> people = Arrays.asList(
                    new Person("Alice", 30, 50000.0),
                    new Person("Bob", 25, 60000.0),
                    new Person("Charlie", 35, 70000.0)
            );

            Comparator<Person> bySalaryDescending = (person1, person2) -> Double.compare(person2.getSalary(), person1.getSalary());

            people.stream()
                    .sorted(bySalaryDescending)
                    .filter(person -> person.getAge() > 30)
                    .map(person -> new Person(person.getName(), person.getAge(), person.getSalary() * 1.1))
                    .forEach(System.out::println);
        }}
}


