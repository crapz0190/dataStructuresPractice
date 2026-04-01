package model.exercise4_SinglyLinkedList;

public class Main {
    public static void main(String[] args) {
        var sList = new SinglyLinkedList<Integer>();
        Integer num1 = 34;
        Integer num2 = 65;
        Integer num3 = 12;
        Integer num4 = 65;
        sList.addFirst(num1);
        sList.addFirst(num2);
        sList.addLast(num3);
        sList.addLast(num4);

        try {
            Integer num5 = 23;
            int position = 2;

            sList.addPos(num5, position);
            System.out.println(sList);
            System.out.println("Size of list: " + sList.size());
        } catch (IndexOutOfBoundsException e) {
            System.err.println(e.getMessage());
        }
    }
}
