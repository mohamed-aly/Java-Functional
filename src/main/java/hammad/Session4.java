package hammad;

import java.time.LocalDate;
import java.util.Comparator;
import java.util.List;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.DoubleStream;

public class Session4 {

    static Function<Order, Boolean> qualifierA = order ->
            order.getExpiryDate().isAfter(LocalDate.now())
                    & order.getExpiryDate().isBefore(LocalDate.now().plusMonths(2));

    static Function<Order, Double> calculatorA = order -> 0.2;

    static Function<Order, Boolean> qualifierB = order ->
            order.getQuantity() > 100 && order.getUnitPrice() > 400;

    static Function<Order, Double> calculatorB = order -> 0.15;

    static Function<Order, Boolean> qualifierC = order ->
            order.getQuantity() > 100 && order.getUnitPrice() < 400;

    static Function<Order, Double> calculatorC = order -> 0.1;

    static Supplier<List<Rule>> rules = () -> List.of(
            new Rule(qualifierA, calculatorA),
            new Rule(qualifierB, calculatorB),
            new Rule(qualifierC, calculatorC)
    );

    static Function<Order, Function<List<Rule>, Order>> getOrderWithDiscount = order -> (rules -> {
        double discount = rules.stream()
                .filter(rule -> rule.qualifier.apply(order))
                .map(rule -> rule.calculator.apply(order))
                .sorted(Comparator.reverseOrder())
                .limit(2)
                .flatMapToDouble(DoubleStream::of)
                .average()
                .orElse(0.0);

        order.setDiscount(discount);
        return order;
    });

    public static void main(String[] args) {

        Order order1 = new Order(1, 100, 101, 101, 0.0,
                LocalDate.of(2022, 5, 24));
        Order order2 = new Order(2, 200, 10, 102, 0.0,
                LocalDate.of(2022, 6, 24));
        Order order3 = new Order(3, 300, 101, 101, 0.0,
                LocalDate.of(2022, 5, 24));
        Order order4 = new Order(4, 100, 101, 101, 0.0,
                LocalDate.of(2022, 5, 24));
        Order order5 = new Order(5, 100, 101, 101, 0.0,
                LocalDate.of(2022, 5, 24));

        List<Order> orders = List.of(order1, order2, order3, order4, order5);

        orders.forEach(order -> {
            getOrderWithDiscount.apply(order).apply(rules.get());
            System.out.println(order);
        });

    }


}

class Rule {
    Function<Order, Boolean> qualifier;
    Function<Order, Double> calculator;

    public Rule(Function<Order, Boolean> qualifier, Function<Order, Double> calculator) {
        this.qualifier = qualifier;
        this.calculator = calculator;
    }

}
