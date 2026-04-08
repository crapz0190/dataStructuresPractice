package model.exercise7_ArrayList;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;

class ConcatPositiveNumbersProblem {

    public static ArrayList<Integer> concatPositiveNumbers(ArrayList<Integer> l1, ArrayList<Integer> l2) {
        ArrayList<Integer> result1 = l1.stream().filter(p -> p > 0).collect(Collectors.toCollection(ArrayList::new));
        ArrayList<Integer> result2 = l2.stream().filter(p -> p > 0).collect(Collectors.toCollection(ArrayList::new));

        result1.addAll(result2);
        return result1;
    }

    public static ArrayList<Integer> concatPositiveNumbers2(ArrayList<Integer> l1, ArrayList<Integer> l2) {
        l1.addAll(l2);
        l1.removeIf(p -> p < 0);
        return l1;
    }

    /* Do not modify this method */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        ArrayList<Integer> list1 = readArrayList(scanner);
        ArrayList<Integer> list2 = readArrayList(scanner);

        ArrayList<Integer> result = concatPositiveNumbers(list1, list2);

        result.forEach(n -> System.out.print(n + " "));
    }

    /* Do not modify this method */
    private static ArrayList<Integer> readArrayList(Scanner scanner) {
        return Arrays
                .stream(scanner.nextLine().split("\\s+"))
                .map(Integer::parseInt)
                .collect(Collectors.toCollection(ArrayList::new));
    }
}