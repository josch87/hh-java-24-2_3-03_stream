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

        List<Integer> evenNumbers = numbers.stream().filter((number) -> {return number % 2 == 0;}).peek(System.out::println).collect(Collectors.toList());
        System.out.println(evenNumbers);


    }
}
