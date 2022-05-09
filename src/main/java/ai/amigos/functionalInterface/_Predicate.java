package ai.amigos.functionalInterface;

import java.util.function.Predicate;

public class _Predicate {
    public static void main(String[] args) {
        System.out.println(isPhoneNumberValid("07123456789"));
        System.out.println(isPhoneNumberValid("0712345678"));
        System.out.println(isPhoneNumberValid("09123456789"));


        System.out.println(isPhoneNumberValidPredicate.test("07123456789"));
        System.out.println(isPhoneNumberValidPredicate.test("0712345678"));
        System.out.println(isPhoneNumberValidPredicate.test("09123456789"));

        //predicate chaining
        System.out.println(isPhoneNumberValidPredicate.and(containsNumber3).test("07123456789"));
        System.out.println(isPhoneNumberValidPredicate.or(containsNumber3).test("0712345678"));
    }

    static Predicate<String> isPhoneNumberValidPredicate = phoneNumber ->
            phoneNumber.startsWith("07") && phoneNumber.length() == 11;

    static Predicate<String> containsNumber3 = phoneNumber -> phoneNumber.contains("3");

    static boolean isPhoneNumberValid(String phoneNumber){
        return phoneNumber.startsWith("07") && phoneNumber.length() == 11;
    }
}
