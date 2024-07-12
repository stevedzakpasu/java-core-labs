package week1.oop;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class exercise6 {
    public static void main(String[] args) {
        // Initialize a list of Person objects
        List<Person> people = Arrays.asList(
                new Person("Alice", 30, 50000.0),
                new Person("Bob", 25, 60000.0),
                new Person("Charlie", 35, 70000.0)
        );

        // Define a comparator to sort people by salary in descending order
        Comparator<Person> bySalaryDescending = (person1, person2) -> Double.compare(person2.getSalary(), person1.getSalary());

        // Stream the list, sort, filter, modify, and print each person
        people.stream()
                .sorted(bySalaryDescending) // Sort by salary in descending order
                .filter(person -> person.getAge() > 30) // Filter to include only people older than 30
                .map(person -> new Person(person.getName(), person.getAge(), person.getSalary() * 1.1)) // Increase salary by 10%
                .forEach(System.out::println); // Print each person in the resulting stream
    }
}