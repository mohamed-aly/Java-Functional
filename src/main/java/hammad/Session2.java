package hammad;

import java.util.List;

public class Session2 {
    public static void main(String[] args) {
        List<Integer> numbers = List.of(1, 7, 5, 9, 4, 2);
        //imperative
        for (int number : numbers) {
            System.out.println(addTen(square(subtractOne(number))));
        }

        //declarative
        numbers.stream()
                .map(Session2::subtractOne)
                .map(Session2::square)
                .filter(n -> n > 20)
                .map(Session2::addTen)
                .forEach(System.out::println);
    }

    private static int subtractOne(int number) {
        return number - 1;
    }

    private static int square(int number) {
        return number * number;
    }

    private static int addTen(int number) {
        return number + 10;
    }
}
