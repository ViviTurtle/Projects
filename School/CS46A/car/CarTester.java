/**
   This program tests the Car class.
*/
public class CarTester
{ 
   public static void main(String [] args)
   { 
      Car myHybrid = new Car(10); 
      myHybrid.addGas(20); 
      myHybrid.addGas(10);
      double gasLeft = myHybrid.getGasInTank();       
      System.out.print("Gas left: ");
      System.out.println(gasLeft);
      System.out.println("Expected: 30");
      myHybrid.drive(200); 
      myHybrid.drive(100);
      double milesDriven = myHybrid.getMilesDriven();       
      System.out.print("Miles driven: ");
      System.out.println(milesDriven);
   }
}