
import java.util.NoSuchElementException;

/**
 *
 * A linked list is a sequence of nodes with efficient element insertion and
 * removal. This class contains a subset of the methods of the standard
 * java.util.LinkedList class.
 *
 */
public class LinkedList {

    int currentSize = 0;

    public int size1() {

        int count = 0;
        LinkedListIterator iterator = new LinkedListIterator();
        while (iterator.hasNext()) {
            count++;
            iterator.next();
        }
        return count;
    }

    public int size2() {
        return sizeHelper(first);
    }

    private static int sizeHelper(Node start) {
        if (start == null) {
            return 0;
        }
        return sizeHelper(start.next) + 1;
    }

    public int size3() {
        return currentSize;
    }

    public LinkedList unzip() {

        LinkedList temp = new LinkedList();
        Node current = first;
        while (current.next != null && current.next.next != null) {
            temp.addLast(current.next);
            current.next = current.next.next;
            current = current.next;

        }
        if (current.next != null && current.next.next == null) {
            temp.addLast(current.next);
            current.next = null;

        }
        return temp;
    }

    private void addLast(Node element) {
        if (first == null) {
            addFirst(element.data);
        } else {
            Node current = first;

            while (current.next != null) {
                current = current.next;
            }
            Node temp = new Node();
            temp.data = element.data;
            temp.next = null;
            current.next = temp;
        }
    }
    private Node first;

    /**
     *
     * Constructs an empty linked list.
     *
     */
    public LinkedList() {
        first = null;
    }

    /**
     *
     * Returns the first element in the linked list.
     *
     * @return the first element in the linked list
     *
     */
    public Object getFirst() {
        if (first == null) {
            throw new NoSuchElementException();
        }
        return first.data;
    }

    /**
     *
     * Removes the first element in the linked list.
     *
     * @return the removed element
     *
     */
    public Object removeFirst() {
        if (first == null) {
            throw new NoSuchElementException();
        }
        Object element = first.data;
        first = first.next;
        currentSize--;
        return element;

    }

    /**
     *
     * Adds an element to the front of the linked list.
     *
     * @param element the element to add
     *
     */
    public void addFirst(Object element) {
        Node newNode = new Node();
        newNode.data = element;
        newNode.next = first;
        currentSize++;
        first = newNode;

    }

    /**
     *
     * Returns an iterator for iterating through this list.
     *
     * @return an iterator for iterating through this list
     *
     */
    public ListIterator listIterator() {
        return new LinkedListIterator();
    }

    class Node {

        public Object data;
        public Node next;
    }

    class LinkedListIterator implements ListIterator {

        private Node position;
        private Node previous;
        private boolean isAfterNext;

        /**
         *
         * Constructs an iterator that points to the front of the linked list.
         *
         */
        public LinkedListIterator() {
            position = null;
            previous = null;
            isAfterNext = false;
        }

        /**
         *
         * Moves the iterator past the next element.
         *
         * @return the traversed element
         *
         */
        public Object next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            previous = position; // Remember for remove
            isAfterNext = true;

            if (position == null) {
                position = first;
            } else {
                position = position.next;
            }

            return position.data;

        }

        /**
         *
         * Tests if there is an element after the iterator position.
         *
         * @return true if there is an element after the iterator position
         *
         */
        public boolean hasNext() {
            if (position == null) {
                return first != null;
            } else {
                return position.next != null;
            }

        }

        /**
         *
         * Adds an element before the iterator position and moves the iterator
         * past the inserted element.
         *
         * @param element the element to add
         *
         */
        public void add(Object element) {
            if (position == null) {
                addFirst(element);
                position = first;
            } else {
                Node newNode = new Node();
                newNode.data = element;
                newNode.next = position.next;
                position.next = newNode;
                position = newNode;
            }
            currentSize++;
            isAfterNext = false;

        }

        /**
         *
         * Removes the last traversed element. This method may only be called
         * after a call to the next method.
         *
         */
        public void remove() {
            if (!isAfterNext) {
                throw new IllegalStateException();
            }

            if (position == first) {
                removeFirst();
            } else {
                previous.next = position.next;
            }
            currentSize--;
            position = previous;
            isAfterNext = false;

        }

        /**
         *
         * Sets the last traversed element to a different value.
         *
         * @param element the element to set
         *
         */
        public void set(Object element) {
            if (!isAfterNext) {
                throw new IllegalStateException();
            }
            position.data = element;
        }
    }
}