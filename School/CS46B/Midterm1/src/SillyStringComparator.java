
import java.util.Comparator;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author user
 */
public class SillyStringComparator implements Comparator<String>
{
       @Override
       public int compare(String o1, String o2) {
          if (o1.equals("")) {
             return 1;
          }
          if (o2.equals("")) {
             return -1;
          }
          String s1 = o1.substring(1) + o1.substring(0,1);
          String s2 = o2.substring(1) + o2.substring(0,1);
          return s1.compareTo(s2);
       }   
}
