package examples;
import java.util.List;
import java.util.stream.Collectors;


sealed interface MyData {}
record Text(String s) implements MyData {}
record Number(int n) implements MyData {}

public class JavaData {
    public static void main(String[] args) {
        var dataList = List.of(new Text("hello"), new Number(10), new Text("world"), new Number(20));

        int sumNumbers = dataList.stream()
                .filter(d -> d instanceof Number)
                .mapToInt(d -> ((Number) d).n())
                .sum();

        String combinedText = dataList.stream()
                .filter(d -> d instanceof Text)
                .map(d -> ((Text) d).s())
                .collect(Collectors.joining(" "));

        System.out.println("Sum of numbers: "+sumNumbers);
        System.out.println("Combined text: "+combinedText);
    }
}