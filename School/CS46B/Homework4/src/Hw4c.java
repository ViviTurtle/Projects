/*
 * This tests if strings can be interweaven together
 */

public class Hw4c {
    /*
     * This weaves two strings together and tests if its similar to c
     * @param a the first string to weave
     * @param b the second string to weave
     * @param c the third string to see if the first two can be weaven to this fashion
     * @return true if a weavened with b can turn into c.
     */

    public static boolean everyDayImShuffling(String a, String b, String c) {
        if (c.length() <= 1) {
            return true;
        }
        if (a.length() > 0) {
            if (c.charAt(0) == a.charAt(0)) {
                return everyDayImShuffling(a.substring(1), b, c.substring(1));
            }
        } else if (b.length() > 0) {
            if (c.charAt(0) == b.charAt(0)) {
                return everyDayImShuffling(a, b.substring(1), c.substring(1));
            }
        }
        
        return false;
    }
}
