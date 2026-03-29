package model.exercise2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class EjemploStreams {
    public static void main(String[] args) {
        List<Producto> inventario = Arrays.asList(
                new Producto("Manzana", "Fruta", 1.5),
                new Producto("Leche", "Lácteo", 2.0),
                new Producto("Plátano", "Fruta", 0.8),
                new Producto("Queso", "Lácteo", 5.0),
                new Producto("Arroz", "Granos", 1.2)
        );

        // ---------------------- El código declarativo (Streams) ----------------------
        System.out.println("---------------------- El código declarativo (Streams) ----------------------");
        // Agrupamos por el metodo getCategoria
        Map<String, List<Producto>> productosPorCategoriaStreams = inventario.stream()
                .collect(Collectors.groupingBy(Producto::getCategoria));

        // Imprimimos el resultado
        imprimir(productosPorCategoriaStreams);

        // ---------------------- El código imperativo (Tradicional) ----------------------
        System.out.println("---------------------- El código imperativo (Tradicional) ----------------------");
        Map<String, List<Producto>> productosPorCategoriaImp = new HashMap<>();
        // Agrupamos por el metodo getCategoria
        for (Producto producto : inventario) {
            String categoria = producto.getCategoria();
            if (!productosPorCategoriaImp.containsKey(categoria)) {
                productosPorCategoriaImp.put(categoria, new ArrayList<>());
            }
            productosPorCategoriaImp.get(categoria).add(producto);
        }

        // Imprimimos el resultado
        imprimir(productosPorCategoriaImp);
    }

    public static void imprimir(Map<String, List<Producto>> productosPorCategoria) {
        productosPorCategoria.forEach((categoria, lista) -> {
            System.out.println("Categoría: " + categoria);
            System.out.println("  -> " + lista);
        });
    }
}
