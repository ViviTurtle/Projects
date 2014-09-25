/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author TODD
 */
public class Hw5b {

    private int[] a;

    public static int swappedPairs(int[] a) {
    int count = 0;
        for (int i = 1; i < a.length; i++) {
            int next = a[i];
// Find the insertion location
// Move all larger elements up
            int j = i;
            while (j > 0 && a[j - 1] > next) {
                a[j] = a[j - 1];
                j--;
                count++;
                System.out.println(a[j] + "," + next);
            }
// Insert the element
            a[j] = next;
        }
        return count;
    }
}
