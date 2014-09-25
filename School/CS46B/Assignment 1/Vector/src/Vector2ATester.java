import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;


/**
 *
 * @author taylor
 */
public class Vector2ATester {
   public static void main(String[] args)
   {
      ArrayList<Vector2A> vectorList = new ArrayList<>();
      vectorList.add(new Vector2A(4, 7));
      vectorList.add(new Vector2A(-5, -5));
      vectorList.add(new Vector2A(0, -1));
      vectorList.add(new Vector2A(3, 5));
      vectorList.add(new Vector2A(4.1, 4));

      Collections.sort(vectorList);
      System.out.println("Received: " + vectorList);
      System.out.println("Expected: [[0.0, -1.0], "
              + "[4.1, 4.0], [3.0, 5.0], "
              + "[-5.0, -5.0], [4.0, 7.0]]");   
      //The sort above works in the draft, it uses the
      //supplied compareTo method.
      Comparator c = Vector2A.getComparatorByDimension(0);
      Collections.sort(vectorList, c);
      System.out.println("Received: " + vectorList);
      System.out.println("Expected: [[0.0, -1.0], "
              + "[4.1, 4.0], [3.0, 5.0], "
              + "[-5.0, -5.0], [4.0, 7.0]]");   
      //The second sort doesn't do anything.  It uses the
      //draft Comparator, which should just return 0 in the draft.

      Vector2A v = new Vector2A(4.1, 4, 65);
      System.out.println("Received: " + v.getValue(0));
      System.out.println("Expected: 0.0");
      System.out.println("Received: " + v.getValue(1));
      System.out.println("Expected: 0.0");
      System.out.println("Received: " + v.getValue(2));
      System.out.println("Expected: 0.0");
      System.out.println("Received: " + v.getValue(3));
      System.out.println("Expected: 0.0");
      System.out.println("Received: " + v.getValue(23));
      System.out.println("Expected: 0.0");

      v.add(13);
      System.out.println("Received: " + v.getValue(0));
      System.out.println("Expected: 0.0");
      System.out.println("Received: " + v.getValue(1));
      System.out.println("Expected: 0.0");
      System.out.println("Received: " + v.getValue(2));
      System.out.println("Expected: 0.0");
      System.out.println("Received: " + v.getValue(3));
      System.out.println("Expected: 0.0");
      System.out.println("Received: " + v.getValue(23));
      System.out.println("Expected: 0.0");

   }
}
