/**
   This program tests the Car class.
*/
public class CarTester2
{ 
   public static void main(String [] args)
   { 
      Car car2 = new Car(10); 
      car2.addGas(20); 
      car2.drive(200); 
      car2.drive(100); 
      double gasLeft = car2.getGasInTank();       
      System.out.print("Gas left: ");
      System.out.println(gasLeft);
      System.out.println("Expected: -10");
   } 
}