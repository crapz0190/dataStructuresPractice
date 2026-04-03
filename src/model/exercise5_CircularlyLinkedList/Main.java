package model;

import model.exercise5_CircularlyLinkedList.CircularlyLinkedList;

public class Main {
    public static void main(String[] args) {
        var cList = new CircularlyLinkedList<Integer>();
        Integer num1 = 25;
        Integer num2 = 12;
        Integer num3 = 50;
        Integer num4 = 17;
        Integer num5 = 41;
        cList.addFirst(num1);
        cList.addFirst(num2);
        cList.addFirst(num3);
        cList.addLast(num4);
        cList.addLast(num5);

        System.out.println("CircularlyLinkedList: " + cList);

        try {
            // ------------------------ addPos ------------------------
            int position = 1;
            Integer addNum = 34;
            cList.addPos(addNum, position);

            System.out.println("addPos -> CircularlyLinkedList: " + cList);

            // ------------------------ removeElement ------------------------
            Integer target = 25;
            Integer removeNum = cList.removeElement(target);
            System.out.println("removeElement -> CircularlyLinkedList: " + removeNum);
            System.out.println("removeElement -> CircularlyLinkedList: " + cList);

        } catch (IndexOutOfBoundsException e) {
            System.out.println("IndexOutOfBoundsException: " + e.getMessage());
        }

        // ------------------------ removePos ------------------------
        var testList = new CircularlyLinkedList<Integer>();
        testList.addFirst(25);
        testList.addFirst(12);
        testList.addLast(34);
        try {
            System.out.println("1er - CircularlyLinkedList: " + testList.first());
            System.out.println("2nd - CircularlyLinkedList: " + testList.last());
            System.out.println("remove last element -> CircularlyLinkedList: " + testList.removeLast());
            System.out.println("isEmpty -> CircularlyLinkedList: " + testList.isEmpty());
            System.out.println("CircularlyLinkedList: " + testList);
        } catch (IndexOutOfBoundsException e) {
            System.out.println("IndexOutOfBoundsException: " + e.getMessage());
        }

    }
}
