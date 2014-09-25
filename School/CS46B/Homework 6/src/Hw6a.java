
import java.util.Comparator;

public class Hw6a {

    public Object[] a;
    public Comparator comparison;

    public Hw6a(Object[] anArray, Comparator aComparator) {
        a = anArray;
        comparison = aComparator;
    }

    public void sort() {
        if (a.length <= 1) {
            return;
        }

        int range = -1;
        int offset = 0;
        for (int i = 2; i <= a.length / 2; i = i * 2) {
            range++;
            offset++;
            for (int j = 0; j < a.length; j = j + i) {
                System.out.println("Merging " + j + "..." + (j + range) + " and " + (j + offset) + "..." + (j + offset + range));
                Object[] first = new Object[range];
                Object[] second = new Object[range];
                // Copy the first half of a into first, the second half into second
                for (int k = 0; k < first.length; k++) {
                    first[k] = (Object) a[k];
                }
                for (int l = 0; l < second.length; l++) {
                    second[l] = (Object) a[first.length + l];
                }
                merge(first, second);
            }
        }
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
}
