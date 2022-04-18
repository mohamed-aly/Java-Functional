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

class Order {
    private Integer id;
    private double unitPrice;
    private int quantity;
    private int productIndex;
    private double discount;

    public Order(Integer id, double unitPrice, int quantity, int productIndex, double discount) {
        this.id = id;
        this.unitPrice = unitPrice;
        this.quantity = quantity;
        this.productIndex = productIndex;
        this.discount = discount;
    }

    public void setDiscount(double discount) {
        this.discount = discount;
    }

    public double getUnitPrice() {
        return unitPrice;
    }

    public int getQuantity() {
        return quantity;
    }

    public int getProductIndex() {
        return productIndex;
    }

    public double getDiscount() {
        return discount;
    }
}
