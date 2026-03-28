package model.exercise1;

public interface List<E> {
    /**
     * Returns the number of elements in the list.
     *
     * @return number of elements in the list
     */
    int size();

    /**
     * Tests whether the list is empty.
     *
     * @return true if the list is empty, false otherwise
     */
    boolean isEmpty();

    /* Add an element to the end of the list */
    void add(E element);

    // Add an element to the list at the position (index)
    void add(int index, E element) throws IndexOutOfBoundsException;

    // Returns the element at (index)
    E get(int index) throws IndexOutOfBoundsException;

    // Remove element E from the list. Returns null if it isn't found
    E remove(E element);

    // Removes the element that be found at the position (index)
    E remove(int index) throws IndexOutOfBoundsException;


}
