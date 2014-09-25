
import java.util.Comparator;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author TODD
 */
public class Hw6aTester {

    public static void main(String[] args) {
         Integer[] in1 = {4, 6, 12, 3, 11, 7, 15, 9, 10, 1, 13, 2, 5, 16, 8, 14};
         Comparator comparing = new Comparison();
        Hw6a test = new Hw6a(in1, comparing);
        test.sort();
       
        
    
    }
     static class Comparison implements Comparator {

       
        @Override
        public int compare(Object x, Object y) {
        
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
}

