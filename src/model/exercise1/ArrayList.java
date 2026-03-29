package model.exercise1;

import java.util.Arrays;
import java.util.Objects;
import java.util.stream.Collectors;

public class ArrayList<E> implements List<E> {
    public static final int CAPACITY = 16;
    private E[] data;
    private int size = 0;

    public ArrayList() {
        this(CAPACITY);
    }

    @SuppressWarnings({"unchecked"})
    public ArrayList(int capacity) {         // constructs list with given capacity
        data = (E[]) new Object[capacity];
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    public boolean isFull() {
        return size == data.length;
    }

    /* Add an element to the end of the list */
    @Override
    public void add(E element) {
        if (isFull()) resize(2 * data.length);
        data[size++] = element;
    }

    // Add an element to the list at the position (index)
    @Override
    public void add(int index, E element) throws IndexOutOfBoundsException {
        checkIndex(index, size + 1);
        if (isFull()) resize(2 * data.length);
        for (int i = size - 1; i >= index; i--) {
            data[i + 1] = data[i];
        }
        data[index] = element;
        size++;
    }

    // Returns the element at (index)
    @Override
    public E get(int index) throws IndexOutOfBoundsException {
        checkIndex(index, size);
        return data[index];
    }

    // Remove element E from the list. Returns null if it isn't found
    @Override
    public E remove(E element) {
        for (int i = 0; i < size; i++) {
            /*if ((element == null && data[i] == null) || element != null && element.equals(data[i])) {
                return remove(i);
            }*/
            if (Objects.equals(data[i], element)) {
                return remove(i);
            }
        }
        return null;
    }

    // Removes the element that be found at the position (index)
    @Override
    public E remove(int index) throws IndexOutOfBoundsException {
        checkIndex(index, size);
        E temp = data[index];
        for (int k = index; k < size - 1; k++) { // shift elements to fill hole
            data[k] = data[k + 1];
        }
        data[size - 1] = null; // help garbage collection
        size--;
        return temp;
    }

    // utility methods

    /**
     * Checks whether the given index is in the range [0, n-1].
     */
    protected void checkIndex(int index, int limit) throws IndexOutOfBoundsException {
        if (index < 0 || index >= limit) {
            throw new IndexOutOfBoundsException("Illegal index: " + index);
        }
    }

    /**
     * Resizes internal array to have given capacity >= size.
     */
    @SuppressWarnings({"unchecked"})
    protected void resize(int capacity) {
        E[] temp = (E[]) new Object[capacity]; // safe cast; compiler may give warning
        for (int k = 0; k < size; k++) {
            temp[k] = data[k];
        }
        data = temp; // start using the new array
    }

    @Override
    public String toString() {
        /*StringBuilder sb = new StringBuilder();
        sb.append("[");
        for (int i = 0; i < size; i++) {
            if (i > 0) sb.append(", ");
            sb.append(data[i]);
        }
        sb.append("]");
        return sb.toString();
        */
        return "[" + Arrays.stream(data, 0, size) // Create the stream only of valid elements
                .map(String::valueOf) // Convert each E element to String
                .collect(Collectors.joining(", ")) // Join each element with a comma and a space
                + "]";
    }
}
