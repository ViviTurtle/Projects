/*
 * This finds the greatest common devisor between two ints.
 */

public class Hw4a {
    /*
     * This finds the greatest common devisor between the ints, x and y.
     * @param x the first interger to be compared to
     * @param y the second interger to be compared to
     * @return the greatest common devisor.
     */

    public static int gcd(int x, int y) {
        int big = x;
        int small = y;
        if (y > x) {
            big = y;
            small = x;
        }
        if (x == 0) {
            return y;
        }
        if (y == 0) {
            return x;
        }
        return gcd(big - small, small);
    }
}