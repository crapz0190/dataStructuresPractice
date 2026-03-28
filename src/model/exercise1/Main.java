package model.exercise1;

public class Main {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        list.add(54);
        list.add(23);
        list.add(2);
        list.add(73);

        System.out.println("Lista original: " + list.toString());
        System.out.println("Esta vacio?: " + list.isEmpty());
        System.out.println("Cantidad de elementos: " + list.size());

        try {
            Integer num = 92;
            list.add(2, num);
            System.out.println("Nueva lista: " + list.toString());

            int index = 2;
            System.out.println("Elemento en el indice " + index + ": " + list.get(index));

            Integer num2 = 23;
            System.out.println("Elemento eliminado: " + list.remove(num2));

            System.out.println("Elemento eliminado en el indice " + index + ": " + list.remove(index));

            System.out.println("Lista actualizada: " + list.toString());

        } catch (IndexOutOfBoundsException e) {
            System.err.println("Error: " + e.getMessage());
        }


    }

}
