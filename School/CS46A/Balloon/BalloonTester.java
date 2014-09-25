/**
   This program tests the Balloon class.
 */
public class BalloonTester
{
   public static void main(String[] args)
   {
      Balloon myBalloon = new Balloon();

      System.out.println("Volume: " + myBalloon.getVolume());
      System.out.println("Expected: 0");

      System.out.println("Surface area: " + myBalloon.getSurfaceArea());
      System.out.println("Expected: 0");
      
      System.out.println("Radius: " + myBalloon.getRadius());
      System.out.println("Expected: 0");

      myBalloon.addAir(100);
      
      System.out.println("Volume: " + myBalloon.getVolume());
      System.out.println("Expected: 100");

      System.out.println("Surface area: " + myBalloon.getSurfaceArea());
      System.out.println("Expected: 104.18794157356089");
      
      System.out.println("Radius: " + myBalloon.getRadius());
      System.out.println("Expected: 2.8794119114848606");
      
      myBalloon.addAir(100);
      
      System.out.println("Volume: " + myBalloon.getVolume());
      System.out.println("Expected: 200");

      System.out.println("Surface area: " + myBalloon.getSurfaceArea());
      System.out.println("Expected: 165.38804805627188");
      
      System.out.println("Radius: " + myBalloon.getRadius());
      System.out.println("Expected: 3.6278316785978095");
   }
}

