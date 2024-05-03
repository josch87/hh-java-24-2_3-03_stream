import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

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

        int sumOfdoubledAndSortedEvenNumbers = doubledAndSortedEvenNumbers.stream().reduce(0, Integer::sum);

        System.out.println("sumOfdoubledAndSortedEvenNumbers: " + sumOfdoubledAndSortedEvenNumbers);
    }
}
