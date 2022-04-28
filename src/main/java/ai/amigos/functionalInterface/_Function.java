package ai.amigos.functionalInterface;

import java.util.function.Function;

public class _Function {
    public static void main(String[] args) {
        System.out.println(increaseByOne(5));
        System.out.println(increaseByOneFunction.apply(5));

        System.out.println(increaseByOneThenMultiplyBy10Function.apply(5));
    }

    static Function<Integer, Integer> increaseByOneFunction = number -> ++number;

    static Function<Integer, Integer> multiplyBy10Function = number -> number * 10;

    //chaining functions
    static Function<Integer, Integer> increaseByOneThenMultiplyBy10Function =
            increaseByOneFunction.andThen(multiplyBy10Function);

    static int increaseByOne(Integer number) {
        return ++number;
    }

}
