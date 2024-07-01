package examples.functional;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class FunctionalProgrammingExample {
    public static void main(String[] args) {
        // List of numbers
        List<Integer> numbers = List.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);

        // Using Predicate functional interface to filter even numbers
        Predicate<Integer> isEven = number -> number % 2 == 0;
        List<Integer> evenNumbers = numbers.stream()
                .filter(isEven)
                .collect(Collectors.toList());

        // Using Function functional interface to double the numbers
        Function<Integer, Integer> doubleNumber = number -> number * 2;
        List<Integer> doubledNumbers = evenNumbers.stream()
                .map(doubleNumber)
                .collect(Collectors.toList());

        // Using Consumer functional interface to print the numbers
        Consumer<Integer> printNumber = number -> System.out.println(number);
        doubledNumbers.forEach(printNumber);

        // Combining all operations in a single stream pipeline
        List<Integer> result = numbers.stream()
                .filter(isEven)
                .map(doubleNumber)
                .collect(Collectors.toList());

        System.out.println("Result: " + result);
    }
}
