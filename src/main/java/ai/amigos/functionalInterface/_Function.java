package ai.amigos.functionalInterface;

import java.util.function.Function;

public class _Function {
    public static void main(String[] args) {
        System.out.println(increaseByOne(5));
        System.out.println(increaseByOneFunction.apply(5));
    }

    static Function<Integer, Integer> increaseByOneFunction = number -> ++number;

    static int increaseByOne(Integer number) {
        return ++number;
    }
}
