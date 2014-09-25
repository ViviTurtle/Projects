/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author TODD
 */
public class Hw5cCountingComparator {

    int count;

    public Hw5cCountingComparator() {
        count = 0;
    }

    public int getCount() {
        return count;
    }

    public int compare(Object x, Object y) {
        count++;
        Integer int1 = (Integer) x;
        Integer int2 = (Integer) y;
        if (int1 < int2) {
            return -1;
        }
        if (int1 > int2) {
            return 1;
        }
        return 0;
    }
}
