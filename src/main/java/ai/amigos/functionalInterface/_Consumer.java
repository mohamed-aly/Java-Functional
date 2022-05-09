package ai.amigos.functionalInterface;

import java.util.function.Consumer;

public class _Consumer {
    public static void main(String[] args) {
        Customer ahmed = new Customer("ahmed", "9999");
        greetCustomer(ahmed);

        //consumer takes one argument and returns nothing, like void method
        Consumer<Customer> consumer = customer ->
                System.out.println("Hello, " + customer.name + " Thanks for registering phone number "
                + customer.phoneNumber);

        consumer.accept(ahmed);

    }

    static void greetCustomer(Customer customer) {
        System.out.println("Hello, " + customer.name + " Thanks for registering phone number "
                + customer.phoneNumber);
    }

    static class Customer {
        private final String name;
        private final String phoneNumber;

        public Customer(String name, String phoneNumber) {
            this.name = name;
            this.phoneNumber = phoneNumber;
        }
    }
}
