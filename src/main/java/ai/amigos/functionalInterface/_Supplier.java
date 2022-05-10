package ai.amigos.functionalInterface;

import java.util.List;
import java.util.function.Supplier;

public class _Supplier {
    public static void main(String[] args) {
        System.out.println(getDbUrl());
        System.out.println(getDbUrlSupplier.get());

    }

    static Supplier<List<String>> getDbUrlSupplier = () ->
            List.of("jdbc://localhost:8080/users",
                    "jdbc://localhost:8080/customers");

    static String getDbUrl() {
        return "jdbc://localhost:8080/users";
    }
}
