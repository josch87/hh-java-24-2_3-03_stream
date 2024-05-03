import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {
        List<Integer> numbers = new ArrayList<>();
        int lengthOfList = 20;

        for (int i = 0; i < lengthOfList; i++) {
            numbers.add(i);
        }

        System.out.println(numbers);

        List<Integer> doubledAndSortedEvenNumbers = numbers.stream()
                .filter((number) -> {
                    return number % 2 == 0;
                })
                .peek(System.out::println)
                .map((number) -> number * 2)
                .sorted()
                .collect(Collectors.toList());

        System.out.println(doubledAndSortedEvenNumbers);

        int sumOfDoubledAndSortedEvenNumbers = doubledAndSortedEvenNumbers.stream().reduce(0, Integer::sum);

        System.out.println("sumOfDoubledAndSortedEvenNumbers: " + sumOfDoubledAndSortedEvenNumbers);

        doubledAndSortedEvenNumbers.forEach(System.out::println);

        try (Stream<String> lines = Files.lines(Path.of("students.csv"))) {
//            lines.peek(System.out::println);

            List<Student> students = lines
                    .skip(1)
                    .filter((line) -> !line.isEmpty())
                    .map((line) -> {
                        String[] values = line.split(",");
                        return new Student(Integer.parseInt(values[0]), values[1], values[2], Integer.parseInt(values[3]));
                    })
                    .toList();

            students.forEach(System.out::println);
        } catch (IOException error) {
            System.out.println("Not able to read students.csv");
        }
    }
}
