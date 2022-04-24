package hammad;

import java.time.LocalDate;
import java.util.Date;

public class Order {
    private Integer id;
    private double unitPrice;
    private int quantity;
    private int productIndex;
    private double discount;
    private LocalDate expiryDate;

    public Order(Integer id, double unitPrice, int quantity, int productIndex, double discount) {
        this.id = id;
        this.unitPrice = unitPrice;
        this.quantity = quantity;
        this.productIndex = productIndex;
        this.discount = discount;
    }

    public Order(Integer id, double unitPrice, int quantity, int productIndex, double discount, LocalDate expiryDate) {
        this.id = id;
        this.unitPrice = unitPrice;
        this.quantity = quantity;
        this.productIndex = productIndex;
        this.discount = discount;
        this.expiryDate = expiryDate;
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

    public LocalDate getExpiryDate() {
        return expiryDate;
    }

    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", unitPrice=" + unitPrice +
                ", quantity=" + quantity +
                ", productIndex=" + productIndex +
                ", discount=" + discount +
                ", expiryDate=" + expiryDate +
                '}';
    }
}
