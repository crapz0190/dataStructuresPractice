package model.exercise1;

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

    /* Add an element to the end of the list */
    @Override
    public void add(E element) {
        if (size == data.length) resize(2 * data.length);
        data[size++] = element;
    }

    // Add an element to the list at the position (index)
    @Override
    public void add(int index, E element) throws IndexOutOfBoundsException {
        checkIndex(index, size + 1);
        if (size == data.length) resize(2 * data.length);
        for (int i = size - 1; i >= index; i--) {
            data[i + 1] = data[i];
        }
        data[index] = element;
        size++;
    }

    // Returns the element at (index)
    @Override
    public E get(int index) throws IndexOutOfBoundsException {
        return null;
    }

    // Remove element E from the list. Returns null if it isn't found
    @Override
    public E remove(E element) {
        return null;
    }

    // Removes the element that be found at the position (index)
    @Override
    public E remove(int index) throws IndexOutOfBoundsException {
        return null;
    }

    // utility methods

    /**
     * Checks whether the given index is in the range [0, n-1].
     */
    protected void checkIndex(int index, int limit) throws IndexOutOfBoundsException {
        if (index < 0 || index >= limit)
            throw new IndexOutOfBoundsException("Illegal index: " + index);
    }

    /**
     * Resizes internal array to have given capacity >= size.
     */
    @SuppressWarnings({"unchecked"})
    protected void resize(int capacity) {
        E[] temp = (E[]) new Object[capacity]; // safe cast; compiler may give warning
        for (int k = 0; k < size; k++)
            temp[k] = data[k];
        data = temp; // start using the new array
    }
}
