
/**
 * This class sorts an array, using the merge sort algorithm.
 */
public class Hw5c {

    private Object[] a;
    private Hw5cCountingComparator comparison;
    private int offset = 0;

    /**
     * Constructs a merge sorter.
     *
     * @param anArray the array to sort
     */
    public Hw5c(Object[] anArray, Hw5cCountingComparator comparison) {
        a = anArray;
        this.comparison = comparison;

    }

    public Hw5c(Object[] anArray, Hw5cCountingComparator comparison, int offs) {
        a = anArray;
        this.comparison = comparison;
        offset = offs;

    }

    /**
     * Sorts the array managed by this merge sorter.
     */
    public void sort() {
        if (a.length <= 1) {
            return;
        }
        Object[] first = new Object[a.length / 2];
        Object[] second = new Object[a.length - first.length];
        // Copy the first half of a into first, the second half into second
        for (int i = 0; i < first.length; i++) {
            first[i] = (Integer) a[i];
        }
        for (int i = 0; i < second.length; i++) {
            second[i] = (Integer) a[first.length + i];
        }
        Hw5c firstSorter = new Hw5c(first, comparison);
        offset += a.length / 2;
        Hw5c secondSorter = new Hw5c(second, comparison, offset);
        firstSorter.sort();
        secondSorter.sort();
        merge(first, second);
    }

    /**
     * Merges two sorted arrays into the array managed by this merge sorter.
     *
     * @param first the first sorted array
     * @param second the second sorted array
     */
    private void merge(Object[] first, Object[] second) {
        int iFirst = 0; // Next element to consider in the first array
        int iSecond = 0; // Next element to consider in the second array
        int j = 0; // Next open position in a

        // As long as neither iFirst nor iSecond past the end, move
        // the smaller element into a
        while (iFirst < first.length && iSecond < second.length) {
            if ((comparison.compare(first[iFirst], second[iSecond])) == -1) {
                a[j] = first[iFirst];
                iFirst++;

            } else {
                a[j] = second[iSecond];
                iSecond++;

            }

            j++;
        }

        // Note that only one of the two loops below copies entries
        // Copy any remaining entries of the first array
        while (iFirst < first.length) {
            a[j] = first[iFirst];
            iFirst++;
            j++;
        }
        // Copy any remaining entries of the second half
        while (iSecond < second.length) {
            a[j] = second[iSecond];
            iSecond++;
            j++;
        }
    }

    public int getOffset() {
        return offset;
    }
}