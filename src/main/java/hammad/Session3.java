package hammad;

import java.util.List;
import java.util.function.Function;

public class Session3 {
    public static void main(String[] args) {
        Function<Double, Double> dlgtTest1 = Session3::test1;
        Function<Double, Double> dlgtTest2 = Session3::test2;

        List<Function<Double, Double>> functions = List.of(dlgtTest1, dlgtTest2);

        //simple function invocation
        System.out.println(test1(test2(10)));
        System.out.println(test2(test1(10)));

        //Static function reference, invocation through delegates
        System.out.println(dlgtTest1.apply(10.0));
        System.out.println(dlgtTest2.apply(10.0));

        System.out.println(functions.get(0).apply(10.0));
        System.out.println(functions.get(1).apply(10.0));

        //Higher order function
        Function<Double, Double> higherOrderTest1 = value -> value / 2;
        Function<Double, Double> higherOrderTest2 = value -> (value / 4) + 1;

        System.out.println(test3(higherOrderTest1, 10));
        System.out.println(test3(higherOrderTest2, 10));


    }

    private static double test1(double number) {
        return number / 2;
    }

    private static double test2(double number) {
        return (number / 4) + 1;
    }

    private static double test3(Function<Double, Double> function, double value){
        return function.apply(value) + value;
    }
}
