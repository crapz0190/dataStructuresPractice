package model.exercise7_ArrayList;

import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class FindTheNearestNumber {
    public static void main(String[] args) {
        try (Scanner input = new Scanner(System.in)) {
            List<Integer> list = readArrayList(input);
            int target = input.nextInt();

            /*int minDistance = Integer.MAX_VALUE;
            for (int num : numbers) {
                int distance = Math.abs(num - n);
                if (distance < minDistance) {
                    minDistance = distance;
                }
            }*/
            int minDistance = list.stream().mapToInt(e -> Math.abs(e - target)).min().orElse(Integer.MAX_VALUE);

            /*
            // 4. Encontrar todos los números con esa distancia mínima
            List<Integer> result = new ArrayList<>();
            for (int num : numbers) {
                if (Math.abs(num - n) == minDistance) {
                    result.add(num);
                }
            }

            // 5. Ordenar el resultado (según pide la consigna)
            Collections.sort(result);*/

            List<Integer> result = list.stream().filter(e -> Math.abs(e - target) == minDistance).sorted().collect(Collectors.toList());

            for (int i : result) {
                System.out.print(i + " ");
            }

        } catch (InputMismatchException e) {
            System.err.println("Please enter a number");
        }
    }

    private static List<Integer> readArrayList(Scanner input) {
        return Arrays.stream(input.nextLine().split("\\s+"))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
    }
}
