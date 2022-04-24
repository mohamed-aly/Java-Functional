package hammad;

import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.function.Supplier;

public class Session5 {
    public static void main(String[] args) {
        Function<Double, Double> addOneDlgt = Test.get();
        System.out.println(addOneDlgt.apply(5.0));

        System.out.println(AddOneSquareSubtractTen.get().apply(3));

    }

    //function Composition

    private static List<Integer> myData = Arrays.asList(3, 5, 7, 8);

    private static Function<Integer, Integer> SubtractTen = value -> value - 10;
    private static Function<Integer, Integer> Square = value -> value * value;
    private static Function<Integer, Integer> AddOne = value -> value + 1;


    private static Supplier<Function<Double, Double>> Test = () -> x -> x + 1;


    private static Supplier<Function<Integer, Integer>> AddOneSquareSubtractTen = () ->
            AddOne.andThen(Square).andThen(SubtractTen);
}
