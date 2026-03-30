package model.exercise3_interfaces_funcionales;

import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Stream;

public class DataProcessor {
    public static void main(String[] args) {
        // Check if the email is valid
        Predicate<String> isValidEmail = email -> email.contains("@") && email.endsWith(".com");

        // Extract username from email
        Function<String, String> extractUsername = email -> email.split("@")[0].toUpperCase();

        String inputEmail = "java_developer@google.com";

        if (isValidEmail.test(inputEmail)) {
            String username = extractUsername.apply(inputEmail);
            System.out.println(username);
        }
    }


}
