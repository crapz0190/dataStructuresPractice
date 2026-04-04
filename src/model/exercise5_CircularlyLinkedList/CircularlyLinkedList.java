/*
 * Copyright 2014, Michael T. Goodrich, Roberto Tamassia, Michael H. Goldwasser
 *
 * Developed for use with the book:
 *
 *    Data Structures and Algorithms in Java, Sixth Edition
 *    Michael T. Goodrich, Roberto Tamassia, and Michael H. Goldwasser
 *    John Wiley & Sons, 2014
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package model.exercise5_CircularlyLinkedList;

import model.exercise4_SinglyLinkedList.SinglyLinkedList;

/**
 * An implementation of a circularly linked list.
 *
 * @author Michael T. Goodrich
 * @author Roberto Tamassia
 * @author Michael H. Goldwasser
 */
public class CircularlyLinkedList<E> {
    //---------------- nested Node class ----------------

    /**
     * Singly linked node, which stores a reference to its element and
     * to the subsequent node in the list.
     */
    private static class Node<E> {

        /**
         * The element stored at this node
         */
        private E element;     // an element stored at this node

        /**
         * A reference to the subsequent node in the list
         */
        private Node<E> next;  // a reference to the subsequent node in the list

        /**
         * Creates a node with the given element and next node.
         *
         * @param e the element to be stored
         * @param n reference to a node that should follow the new node
         */
        public Node(E e, Node<E> n) {
            element = e;
            next = n;
        }

        // Accessor methods

        /**
         * Returns the element stored at the node.
         *
         * @return the element stored at the node
         */
        public E getElement() {
            return element;
        }

        /**
         * Returns the node that follows this one (or null if no such node).
         *
         * @return the following node
         */
        public Node<E> getNext() {
            return next;
        }

        // Modifier methods

        /**
         * Sets the node's next reference to point to Node n.
         *
         * @param n the node that should follow this one
         */
        public void setNext(Node<E> n) {
            next = n;
        }
    } //----------- end of nested Node class -----------

    // instance variables of the CircularlyLinkedList
    /**
     * The designated cursor of the list
     */
    private Node<E> tail = null;                  // we store tail (but not head)

    /**
     * Number of nodes in the list
     */
    private int size = 0;                         // number of nodes in the list

    /**
     * Constructs an initially empty list.
     */
    public CircularlyLinkedList() {
    }             // constructs an initially empty list

    // access methods

    /**
     * Returns the number of elements in the linked list.
     *
     * @return number of elements in the linked list
     */
    public int size() {
        return size;
    }

    /**
     * Tests whether the linked list is empty.
     *
     * @return true if the linked list is empty, false otherwise
     */
    public boolean isEmpty() {
        return size == 0;
    }

    /**
     * Returns (but does not remove) the first element of the list
     *
     * @return element at the front of the list (or null if empty)
     */
    public E first() {             // returns (but does not remove) the first element
        if (isEmpty()) return null;
        return tail.getNext().getElement();         // the head is *after* the tail
    }

    /**
     * Returns (but does not remove) the last element of the list
     *
     * @return element at the back of the list (or null if empty)
     */
    public E last() {              // returns (but does not remove) the last element
        if (isEmpty()) return null;
        return tail.getElement();
    }

    // update methods

    /**
     * Rotate the first element to the back of the list.
     */
    public void rotate() {         // rotate the first element to the back of the list
        if (tail != null)                // if empty, do nothing
            tail = tail.getNext();         // the old head becomes the new tail
    }

    /**
     * Adds an element to the front of the list.
     *
     * @param e the new element to add
     */
    public void addFirst(E e) {                // adds element e to the front of the list
        if (size == 0) {
            tail = new Node<>(e, null);
            tail.setNext(tail);                     // link to itself circularly
        } else {
            Node<E> newest = new Node<>(e, tail.getNext());
            tail.setNext(newest);
        }
        size++;
    }

    /**
     * Adds an element to the end of the list.
     *
     * @param e the new element to add
     */
    public void addLast(E e) {                 // adds element e to the end of the list
        addFirst(e);             // insert new element at front of list
        tail = tail.getNext();   // now new element becomes the tail
    }

    /**
     * Removes and returns the first element of the list.
     *
     * @return the removed element (or null if empty)
     */
    public E removeFirst() {                   // removes and returns the first element
        if (isEmpty()) return null;              // nothing to remove
        Node<E> head = tail.getNext();
        if (head == tail) tail = null;           // must be the only node left
        else tail.setNext(head.getNext());       // removes "head" from the list
        size--;
        return head.getElement();
    }

    /* Inserta el elemento e en la posicion n de la lista */
    public void addPos(E e, int n) throws IndexOutOfBoundsException {
        checkIndex(n, size + 1);
        if (n == 0) {
            addFirst(e);
        } else if (n == size) {
            addLast(e);
        } else {
            Node<E> walk = tail.getNext();
            for (int i = 0; i < n - 1; i++) {
                walk = walk.getNext();
            }

            Node<E> newest = new Node<>(e, walk.getNext());
            walk.setNext(newest);
            size++;
        }
    }

    /* Elimina el elemento e de la lista
    /* Retorna NULL si no lo encuentra */
    public E removeElement(E e) {
        if (isEmpty() || e == null) return null;
        Node<E> head = tail.getNext();
        if (head.getElement().equals(e)) {
            return removeFirst();
        }

        Node<E> walk = head;
        while (walk.getNext() != head) {
            if (walk.getNext().getElement().equals(e)) {
                Node<E> target = walk.getNext();
                E answer = target.getElement();

                if (target == tail) tail = walk;

                walk.setNext(target.getNext());
                size--;
                return answer;
            }
            walk = walk.getNext();
        }
        return null;
    }

    /* Elimina elemento que se encuentra en la posicion n de la lista */
    /* Retorna NULL si no es una posicion valida */
    public E removePos(int n) throws IndexOutOfBoundsException {
        if (isEmpty()) return null;
        checkIndex(n, size);
        if (n == 0) return removeFirst();
        if (n == size - 1) return removeLast();
        Node<E> walk = tail.getNext();
        for (int i = 0; i < n - 1; i++) {
            walk = walk.getNext();
        }
        E answer = walk.getNext().getElement();
        walk.setNext(walk.getNext().getNext());
        size--;

        return answer;
    }

    public E removeLast() {
        if (isEmpty()) return null;
        E answer = tail.element;
        if (size == 1) {
            tail = null;
        } else {
            Node<E> walk = tail.getNext();
            while (walk.getNext() != tail) {
                walk = walk.getNext();
            }
            walk.setNext(tail.getNext());
            tail = walk;
        }
        size--;
        return answer;
    }

    /**
     * Concatenates all elements from list l to the end of this list.
     * This operation is performed in O(1) time by relinking the tails of both
     * circular structures. After the operation, the source list (l) is cleared
     * to ensure that the nodes are exclusively owned by this list.
     *
     * @param l the CircularlyLinkedList to be appended
     */
    public void concatenate(CircularlyLinkedList<E> l) {
        if (l == null || l.isEmpty()) return;
        if (isEmpty()) {
            tail = l.tail;
        } else {
            Node<E> thisHead = tail.getNext();
            Node<E> otherHead = l.tail.getNext();

            tail.setNext(otherHead);
            l.tail.setNext(thisHead);
            tail = l.tail;
        }
        size += l.size;

        l.tail = null;
        l.size = 0;
    }

    /**
     * Searches for element e within the circular list.
     * It employs an optimization by checking the head and tail (O(1)) before
     * iterating through the intermediate nodes (the "body") of the list.
     *
     * @param e the element to search for
     * @return the element if found, or null if it does not exist in the list
     */
    public E search(E e) {
        if (isEmpty()) return null;
        if (size == 1) {
            if (last().equals(e)) return last();
        } else {
            if (last().equals(e)) return last();
            if (first().equals(e)) return first();

            Node<E> head = tail.getNext();
            while (head.getNext() != tail) {
                if (head.getNext().getElement().equals(e)) {
                    return head.getNext().getElement();
                }
                head = head.getNext();
            }
        }
        return null;
    }

    protected void checkIndex(int index, int limit) throws IndexOutOfBoundsException {
        if (index < 0 || index >= limit) {
            throw new IndexOutOfBoundsException("Illegal index: " + index);
        }
    }

    /**
     * Compares this circularly linked list with the specified object for equality.
     * Two lists are considered equal if they have the same size and contain
     * the same elements in the same order, starting from the designated head.
     *
     * @param o the object to be compared for equality with this list
     * @return true if the specified object is equal to this list
     */
    public boolean equals(Object o) {
        if (o == null) return false;
        if (getClass() != o.getClass()) return false;
        CircularlyLinkedList<?> other = (CircularlyLinkedList<?>) o;
        if (size != other.size) return false;
        if (size == 0) return true;
        Node<E> walkA = tail.getNext();
        Node<?> walkB = other.tail.getNext();
        for (int i = 0; i < size; i++) {
            if (!walkA.getElement().equals(walkB.getElement())) return false;
            walkA = walkA.getNext();
            walkB = walkB.getNext();
        }
        return true;
    }

    /**
     * Produces a string representation of the contents of the list.
     * This exists for debugging purposes only.
     */
    public String toString() {
        if (tail == null) return "()";
        StringBuilder sb = new StringBuilder("(");
        Node<E> walk = tail;
        do {
            walk = walk.getNext();
            sb.append(walk.getElement());
            if (walk != tail)
                sb.append(", ");
        } while (walk != tail);
        sb.append(")");
        return sb.toString();
    }
}
