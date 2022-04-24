package hammad;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

public class Session3Part2 {

    private static Order order = new Order(1, 10, 10, 100, 0.0);

    private static Function<Integer, Map<String, Double>> productParametersFood =
            productIndex -> {
                Map<String, Double> map = new HashMap<>();
                map.put("x1", productIndex / (productIndex + 100.0));
                map.put("x2", productIndex / (productIndex + 300.0));
                return map;
            };

    private static Function<Integer, Map<String, Double>> productParametersBeverage =
            productIndex -> {
                Map<String, Double> map = new HashMap<>();
                map.put("x1", productIndex / (productIndex + 300.0));
                map.put("x2", productIndex / (productIndex + 400.0));
                return map;
            };

    private static Function<Integer, Map<String, Double>> productParametersRawMaterial =
            productIndex -> {
                Map<String, Double> map = new HashMap<>();
                map.put("x1", productIndex / (productIndex + 400.0));
                map.put("x2", productIndex / (productIndex + 700.0));
                return map;
            };

    private static Function<Function<Integer, Map<String, Double>>, Function<Order, Double>> calculateDiscount =
            parameterCalculate -> (order -> {
                Map<String, Double> parameters = parameterCalculate.apply(order.getProductIndex());
                return parameters.get("x1") * order.getUnitPrice() + parameters.get("x2") * order.getQuantity();
            });


    public static void main(String[] args) {

        ProductType type = ProductType.FOOD;
        Function<Integer, Map<String, Double>> calculateParameters =
                type == ProductType.FOOD ? productParametersFood
                        : (type == ProductType.BEVERAGE ? productParametersBeverage : productParametersRawMaterial);

        System.out.println(calculateDiscount.apply(calculateParameters).apply(order));


    }


}

enum ProductType {
    FOOD, BEVERAGE, RAW_MATERIAL;
}


