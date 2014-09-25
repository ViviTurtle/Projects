
public class PersistentList {

    Node first;

    public PersistentList() {
        first = null;
    }

    public PersistentList(Object data, PersistentList tail) {
        first = new Node();
        first.data = data;
        first.next = tail.first;
    }

    public ListIterator listIterator() {
        return new PersistentListIterator();
    }

    static private class Node {

        private Node next;
        private Object data;
    }

    private class PersistentListIterator implements ListIterator {

        private Node position;
        private int index = 0;

        @Override
        public Object next() {

            if (hasNext()) {
                index++;
                Object lala = position.data;
                position = position.next;
                return lala;
            }
            return 0;
        }

        @Override
        public boolean hasNext() {
            if (index == 0) {
                return first != null;
            } else {
                return position != null;
            }
        }

        @Override
        public int nextIndex() {
            return index + 1;
        }

        @Override
        public void add(Object element) {
            throw new UnsupportedOperationException("Not supported.  Ever.");
        }

        @Override
        public void remove() {
            throw new UnsupportedOperationException("Not supported.  Ever.");
        }

        @Override
        public void set(Object element) {
            throw new UnsupportedOperationException("Not supported.  Ever.");
        }
    }
}
