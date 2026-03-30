package model.exercise3_interfaces_funcionales;

import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.UnaryOperator;
import java.util.stream.Collectors;

public class StreamProcessor {
    public static void main(String[] args) {
        List<Double> productPrices = Arrays.asList(100.0, 15.5, 55.0, 200.0, 12.0, 300.0);

        // 1. Predicate: Only products over $50
        Predicate<Double> isExpensive = price -> price > 50.0;

        // 2. UnaryOperator: Apply a 15% discount
        UnaryOperator<Double> applyDiscount = price -> price * 0.85;

        // 3. Function: Convert Double to a formatted String
        Function<Double, String> formatPrice = price -> String.format("Final Price: $%.2f", price);

        // The Stream Pipeline
        List<String> report = productPrices.stream()
                .filter(isExpensive)          // Uses Predicate
                .map(applyDiscount)           // Uses UnaryOperator (specialized Function)
                .map(formatPrice)             // Uses Function
                .collect(Collectors.toList());

        // 4. Consumer: Print each element
        report.forEach(System.out::println);
    }
}
