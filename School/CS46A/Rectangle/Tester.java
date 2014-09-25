public class Tester
{
   public static void main(String[] args)
   {
      Rectangle r = new Rectangle(100, 100, 50, 30);
      Rectangle inside = new Rectangle(110, 110, 20, 10);
      Rectangle outside = new Rectangle(90, 90, 70, 50);
      Rectangle touching = new Rectangle(150, 100, 50, 30);
      Rectangle intersectingLeft = new Rectangle(90, 110, 50, 10);
      Rectangle intersectingRight = new Rectangle(140, 110, 50, 10);
      Rectangle intersectingTop = new Rectangle(110, 90, 20, 20);
      Rectangle intersectingBottom = new Rectangle(110, 120, 20, 20);
      Rectangle toLeft = new Rectangle(40, 100, 50, 30);
      Rectangle toRight = new Rectangle(160, 100, 50, 30);
      Rectangle toTop = new Rectangle(100, 60, 50, 30);
      Rectangle toBottom = new Rectangle(100, 140, 50, 30);

      boolean b1 = r.contains(r);
      System.out.println("1: " + b1);
      System.out.println("Expected: true");
      System.out.println("2: " + r.contains(inside));
      System.out.println("Expected: true");
      System.out.println("3: " + r.contains(outside));
      System.out.println("Expected: false");
      System.out.println("4: " + r.contains(touching));
      System.out.println("Expected: false");
      System.out.println("5: " + r.contains(intersectingLeft));
      System.out.println("Expected: false");
      System.out.println("6: " + r.contains(intersectingRight));
      System.out.println("Expected: false");
      System.out.println("7: " + r.contains(intersectingTop));
      System.out.println("Expected: false");
      System.out.println("8: " + r.contains(intersectingBottom));
      System.out.println("Expected: false");
      System.out.println("9: " + r.contains(toLeft));
      System.out.println("Expected: false");
      System.out.println("10: " + r.contains(toRight));
      System.out.println("Expected: false");
      System.out.println("11: " + r.contains(toTop));
      System.out.println("Expected: false");
      System.out.println("12: " + r.contains(toBottom));
      System.out.println("Expected: false");

      boolean b2 = r.intersects(r);
      System.out.println("13: " + b2);
      boolean b3 = r.isDisjointFrom(r);
      System.out.println("Expected: false"); 
      System.out.println("14: " + b3);
      System.out.println("Expected: false");
   }
}
