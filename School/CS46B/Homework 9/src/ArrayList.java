
import java.util.NoSuchElementException;

/**
 * This is a simplified implementation of an array list.
 */
public class ArrayList {

    public ListIterator listIterator() {
        return new ArrayListIterator();
    }

    private class ArrayListIterator implements ListIterator {

        int position = -1;
        boolean isAfterNext = false;

        @Override
        public Object next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            isAfterNext = true;
            return get(++position);

        }

        @Override
        public boolean hasNext() {
            if (position + 1 >= currentSize) {
                return false;
            }
            return true;
        }

        @Override
        public int nextIndex() {
            return position + 1;
        }

        @Override
        public void add(Object element) {
            if (!isAfterNext) {
                throw new IllegalStateException();
            }
            ArrayList.this.add(++position, element);
            isAfterNext = false;
        }

        @Override
        public void remove() {
            if (!isAfterNext) {
                throw new IllegalStateException();
            }
            ArrayList.this.remove(position);
            isAfterNext = false;


        }

        public void set(Object element) {
            if (!isAfterNext) {
                throw new IllegalStateException();
            }
             ArrayList.this.set(position, element);
            isAfterNext = false;
        }
    }
    //DO NOT CHANGE ANYTHING BELOW THIS LINE
    private Object[] elements;
    private int currentSize;

    /**
     * Constructs an empty array list.
     */
    public ArrayList() {
        final int INITIAL_SIZE = 10;
        elements = new Object[INITIAL_SIZE];
        currentSize = 0;
    }

    /**
     * Gets the size of this array list.
     *
     * @return the size
     */
    public int size() {
        return currentSize;
    }

    /**
     * Throws an IndexOutOfBoundsException if the checked index is out of bounds
     *
     * @param n the index to check
     */
    private void checkBounds(int n) {
        if (n < 0 || n >= currentSize) {
            throw new IndexOutOfBoundsException();
        }
    }

    /**
     * Gets the element at a given position.
     *
     * @param pos the position
     * @return the element at pos
     */
    public Object get(int pos) {
        checkBounds(pos);
        return elements[pos];
    }

    /**
     * Sets the element at a given position.
     *
     * @param pos the position
     * @param element the new value
     */
    public void set(int pos, Object element) {
        checkBounds(pos);
        elements[pos] = element;
    }

    /**
     * Removes the element at a given position.
     *
     * @param pos the position
     * @return the removed element
     */
    public Object remove(int pos) {
        checkBounds(pos);

        Object removed = elements[pos];

        for (int i = pos + 1; i < currentSize; i++) {
            elements[i - 1] = elements[i];
        }

        currentSize--;

        return removed;
    }

    /**
     * Adds an element after a given position.
     *
     * @param pos the position
     * @param newElement the element to add
     */
    public boolean add(int pos, Object newElement) {
        growIfNecessary();
        currentSize++;

        checkBounds(pos);

        for (int i = currentSize - 1; i > pos; i--) {
            elements[i] = elements[i - 1];
        }

        elements[pos] = newElement;
        return true;
    }

    /**
     * Adds an element after the end of the array list
     *
     * @param newElement the element to add
     */
    public boolean addLast(Object newElement) {
        growIfNecessary();
        currentSize++;

        elements[currentSize - 1] = newElement;
        return true;
    }

    /**
     * Grows the elements array if the current size equals the capacity.
     */
    private void growIfNecessary() {
        if (currentSize == elements.length) {
            Object[] newElements = new Object[2 * elements.length];
            for (int i = 0; i < elements.length; i++) {
                newElements[i] = elements[i];
            }
            elements = newElements;
        }
    }
}