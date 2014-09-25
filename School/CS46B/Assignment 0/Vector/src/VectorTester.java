public class VectorTester {
   
   public static void main(String[] args)
   {
      Vector v1 = new Vector(1.9, 2.8);
      Vector v2 = new Vector(3.3, 1.1);
      Vector v3 = v1.add(v2);
      System.out.println("x Value:  " + v3.getX());
      System.out.println("Expected:  5.2");
      System.out.println("y Value:  " + v3.getY());
      System.out.println("Expected:  3.9");
      System.out.println("Magnitude:  " + v3.getMagnitude());
      System.out.println("Expected:  6.5");
   }
}
